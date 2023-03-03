package com.bibimbob.cashcow.service;

import com.bibimbob.cashcow.domain.Stock.FavoriteStock;
import com.bibimbob.cashcow.domain.User;
import com.bibimbob.cashcow.dto.User.UserDto;
import com.bibimbob.cashcow.dto.StockDto.UserStockDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    public Long save(User user) throws Exception;

    public User findOne(long id) throws Exception;

    public Long updateUser(UserDto userDto) throws Exception;

    public Long saveStock(UserStockDto userStockDto) throws Exception;

    Long removeStock(UserStockDto userStockDto) throws Exception;

    Page<FavoriteStock> getStockList(Pageable pageable, Long userPK) throws Exception;

    int findById(String userId) throws Exception;

    void deleteUser(long userId)  throws Exception;
}
