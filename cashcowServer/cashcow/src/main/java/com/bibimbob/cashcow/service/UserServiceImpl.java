package com.bibimbob.cashcow.service;

import com.bibimbob.cashcow.domain.Stock.FavoriteStock;
import com.bibimbob.cashcow.domain.User;
import com.bibimbob.cashcow.dto.StockDto.ResponseStockDto;
import com.bibimbob.cashcow.dto.UserDto;
import com.bibimbob.cashcow.dto.StockDto.UserStockDto;
import com.bibimbob.cashcow.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;

import static java.time.LocalDateTime.now;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    /**
     * 회원 가입(유저 저장)
     */
    @Override
    public Long save(User user) throws Exception {
        user.setCreatedAt(now());
        user.setModifiedAt(now());

        List<User> findUser = userRepository.findById(user.getUserId());
        if (findUser.size() > 0){
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }else{
            userRepository.save(user);
        }

        return user.getId();
    }

    /**
     * 유저 조회
     */
    @Override
    public User findOne(long id) throws Exception {
        User user = userRepository.findOne(id);
        if(user != null){
            return user;
        }else{
            throw new IllegalStateException("존재하지 않는 회원입니다.");
        }
    }


    /**
     * 유저 정보 수정
     */
    @Override
    public Long updateUser(UserDto userDto) throws Exception {

        List<User> findUser = userRepository.findById(userDto.getUserId());
        findUser.get(0).change(
            userDto.getBirth(),
            userDto.getPassword(),
            userDto.getName(),
            userDto.getNickname(),
            userDto.getGender(),
            userDto.getJob(),
            userDto.getStatus(),
            now(),
            userDto.getPhoneNumber(),
            userDto.getSalary());

        return findUser.get(0).getId();
    }

    /**
     * 주식 즐겨찾기 save
     */
    @Override
    public Long saveStock(UserStockDto userStockDto) throws Exception {
        User findUser = userRepository.findOne(userStockDto.getUserPk());
        List<FavoriteStock> oneStock = userRepository.findOneStock(userStockDto.getUserPk(), userStockDto.getStockCode());

        if (oneStock.size() == 0) {
            FavoriteStock favoriteStock = new FavoriteStock(findUser, userStockDto.getStockCode());
            userRepository.saveStock(favoriteStock);
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
        User findUser = userRepository.findOne(userStockDto.getUserPk());

        // DB 에서 해당 엔티티 찾아서 있으면 delete
        List<FavoriteStock> oneStock = userRepository.findOneStock(userStockDto.getUserPk(), userStockDto.getStockCode());

        if(oneStock.size()>=1){
            userRepository.removeStock(oneStock.get(0));
            return oneStock.get(0).getUser().getId();
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
        List<FavoriteStock> stockList = userRepository.findStockList(user);
        return stockList;
    }



}
