package com.bibimbob.cashcow.repository;

import com.bibimbob.cashcow.domain.User;
import org.assertj.core.api.Assertions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@WebAppConfiguration
public class UserJpaRepositoryTest {

    @Autowired UserJpaRepository userJpaRepository;

    @Test
    public void findByUserIdTest() throws Exception{
        //given

        //when
        Optional<User> findUser = userJpaRepository.findByUserId("new_Id");
        //then
        Assertions.assertThat(findUser.get().getId()).isEqualTo(24);
    }

}