package com.bibimbob.cashcow.service;

import com.bibimbob.cashcow.domain.Stock.FavoriteStock;
import com.bibimbob.cashcow.domain.User;
import com.bibimbob.cashcow.dto.StockDto.ResponseStockDto;
import com.bibimbob.cashcow.dto.UserDto;
import com.bibimbob.cashcow.dto.StockDto.UserStockDto;

import java.util.List;

public interface UserService {
    public Long save(User user) throws Exception;

    public User findOne(long id) throws Exception;

    public Long updateUser(UserDto userDto) throws Exception;

    public Long saveStock(UserStockDto userStockDto) throws Exception;

    Long removeStock(UserStockDto userStockDto) throws Exception;

    List<FavoriteStock> getStockList(Long userPK) throws Exception;

    int findById(String userId);
}
