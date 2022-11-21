package com.bibimbob.cashcow.service;

import com.bibimbob.cashcow.domain.User;
import com.bibimbob.cashcow.dto.UserDto;

public interface UserService {
    public User save(UserDto userDto) throws Exception;
    public UserDto getUser(long id) throws Exception;
}
