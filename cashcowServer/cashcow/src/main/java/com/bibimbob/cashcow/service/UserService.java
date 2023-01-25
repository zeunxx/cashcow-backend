package com.bibimbob.cashcow.service;

import com.bibimbob.cashcow.domain.User;
import com.bibimbob.cashcow.dto.UserAssetsDto.UserAssetsDto;
import com.bibimbob.cashcow.dto.UserDto;

public interface UserService {
    public Long save(User user) throws Exception;
    public User findOne(long id) throws Exception;
//    public Long updateAssets(Long assetsId, int temp ,UserAssetsDto userAssetsDto) throws Exception;

    public Long updateUser(Long userId, UserDto userDto) throws Exception;
}
