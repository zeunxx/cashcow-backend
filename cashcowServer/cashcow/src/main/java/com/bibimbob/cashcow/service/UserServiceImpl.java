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
        userRepository.save(user);
        return user.getId();
    }

    /**
     * 유저 조회
     */
    @Override
    public User findOne(long id) throws Exception {
        User user = userRepository.findOne(id);
        return user;
    }


    /**
     * 유저 정보 수정
     */
    @Override
    public Long updateUser(UserDto userDto) throws Exception {
        User findUser = userRepository.findOne(userDto.getId());

        findUser.change(
        userDto.getUserId(),
        userDto.getBirth(),
        userDto.getPassword(),
        userDto.getName(),
        userDto.getNickname(),
        userDto.getGender(),
        userDto.getJob(),
        userDto.getStatus(),
        userDto.getModifiedAt(),
        userDto.getPhoneNumber(),
        userDto.getSalary() );

        return findUser.getId();
    }

    /**
     * 주식 즐겨찾기 save
     */
    @Override
    public Long saveStock(UserStockDto userStockDto) throws Exception {
        User findUser = userRepository.findOne(userStockDto.getId());

        List<FavoriteStock> oneStock = userRepository.findOneStock(userStockDto.getId(), userStockDto.getStockCode());

        if (oneStock.size() == 0) {
            FavoriteStock favoriteStock = new FavoriteStock(findUser, userStockDto.getStockCode());
            userRepository.saveStock(favoriteStock);
        }


        return findUser.getId();
    }

    /**
     * 주식 즐겨찾기 remove
     */
    @Override
    public Long removeStock(UserStockDto userStockDto) throws Exception {
        User findUser = userRepository.findOne(userStockDto.getId());

        // db에서 해당 엔티티 찾아서 있으면 delete
        List<FavoriteStock> oneStock = userRepository.findOneStock(userStockDto.getId(), userStockDto.getStockCode());

        if(oneStock.size()>=1){
            userRepository.removeStock(oneStock.get(0));
            return oneStock.get(0).getId();
        }

        return 0L;
    }

    /**
     *  주식 즐겨찾기 get
     */
    @Override
    public List<FavoriteStock> getStockList(Long userId) throws Exception {
        List<FavoriteStock> stockList = userRepository.findStockList(userId);
        return stockList;
    }



}
