package com.bibimbob.cashcow.repository;

import com.bibimbob.cashcow.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
