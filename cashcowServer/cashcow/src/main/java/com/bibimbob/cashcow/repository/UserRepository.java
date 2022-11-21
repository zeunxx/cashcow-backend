package com.bibimbob.cashcow.repository;

import com.bibimbob.cashcow.domain.User;
import com.bibimbob.cashcow.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findById (String id);

}
