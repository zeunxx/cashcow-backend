package com.bibimbob.cashcow.service;

import com.bibimbob.cashcow.domain.Stock.FavoriteStock;
import com.bibimbob.cashcow.domain.User;
import com.bibimbob.cashcow.dto.StockDto.ResponseStockDto;
import com.bibimbob.cashcow.dto.UserDto;
import com.bibimbob.cashcow.dto.StockDto.UserStockDto;
import com.bibimbob.cashcow.repository.StockJpaRepository;

import com.bibimbob.cashcow.repository.UserJpaRepository;
import com.bibimbob.cashcow.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import static java.time.LocalDateTime.now;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserJpaRepository userJpaRepository;
    private final StockJpaRepository stockJpaRepository;

    /**
     * 회원 가입(유저 저장)
     */
    @Override
    public Long save(User user) throws Exception {

        Optional<User> findUser = userJpaRepository.findByUserId(user.getUserId());// 아이디 DB에 이미 있는지 확인
        if (findUser.isPresent()){ // 1개 이상있으면 에러
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }else{ // 없으면 SAVE
            userJpaRepository.save(user);
        }

        // 위에 다 제거하고 save만!

        return user.getId();
    }

    /**
     * 유저 조회
     */
    @Override
    public User findOne(long id) throws Exception {
        Optional<User> user = userJpaRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }else{
            throw new IllegalStateException("존재하지 않는 회원입니다.");
        }
    }


    /**
     * 유저 정보 수정
     */
    @Override
    public Long updateUser(UserDto userDto) throws Exception {

        Optional<User> findUser = userJpaRepository.findByUserId(userDto.getUserId());
        if(findUser.isPresent()){
            findUser.get().change(
                    userDto.getBirth(),
                    userDto.getPassword(),
                    userDto.getName(),
                    userDto.getNickname(),
                    userDto.getGender(),
                    userDto.getJob(),
                    userDto.getStatus(),
                    userDto.getPhoneNumber(),
                    userDto.getSalary());
        }

        return findUser.get().getId();
    }

    /**
     * 아이디 중복 체크
     */
    @Override
    public int findById(String userId) {
        Optional<User> findUser = userJpaRepository.findByUserId(userId);
        if (findUser.isPresent()){ // 있음
            return 1; //
        }else { // 없음
            return 0;
        }
    }

    /**
     * 회원 정보 삭제
     */
    @Override
    public void deleteUser(long userId) throws Exception{
        stockJpaRepository.deleteAllByUser(findOne(userId));
        userJpaRepository.delete(findOne(userId));
    }

    /**
     * 주식 즐겨찾기 save
     */
    @Override
    public Long saveStock(UserStockDto userStockDto) throws Exception {
        User findUser = findOne(userStockDto.getUserPk());
        Optional<FavoriteStock> findStock = stockJpaRepository.findOne(userStockDto.getUserPk(), userStockDto.getStockCode());

        if (findStock.isEmpty()) {
            FavoriteStock favoriteStock = new FavoriteStock(findUser, userStockDto.getStockCode());
            stockJpaRepository.save(favoriteStock);
            return findUser.getId();
        }else{
            throw new IllegalStateException("이미 해당 유저의 즐겨찾기에 등록된 주식입니다.");
        }

    }

    /**
     * 주식 즐겨찾기 remove
     */
    @Override
    public Long removeStock(UserStockDto userStockDto) throws Exception {

        Optional<User> findUser = userJpaRepository.findById(userStockDto.getUserPk());

        // DB 에서 해당 엔티티 찾아서 있으면 delete
        Optional<FavoriteStock> findStock = stockJpaRepository.findOne(userStockDto.getUserPk(), userStockDto.getStockCode());

        if(findStock.isPresent()){
            stockJpaRepository.delete(findStock.get());
            return findStock.get().getUser().getId();
        }
        // 가입 불가시 에러로 넘길지 고민

        return 0L;
    }

    /**
     *  주식 즐겨찾기 get
     */
    @Override
    public List<FavoriteStock> getStockList(Long userPk) throws Exception {
        User user = findOne(userPk);
        return stockJpaRepository.findByUserPk(user.getId());
    }



}
