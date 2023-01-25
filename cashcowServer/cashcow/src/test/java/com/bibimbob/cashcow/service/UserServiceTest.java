package com.bibimbob.cashcow.service;

import com.bibimbob.cashcow.domain.GENDER;
import com.bibimbob.cashcow.domain.STATUS;
import com.bibimbob.cashcow.domain.User;
import com.bibimbob.cashcow.dto.UserDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.time.LocalDate;

import static java.time.LocalDateTime.now;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired UserService userService;
    @Autowired
    EntityManager em;

    @Test
    public void user_show() throws Exception{
        //given
        Long userId = 3L;

        //when
        User user = userService.findOne(userId);

        //then
        System.out.println(user.getName());
        Assert.assertEquals(3,user.getId());
    }

    @Test
//    @Rollback(false)
    public void user_join() throws Exception{
        //given

        UserDto userDto = new UserDto("1/21 새로 생성","이름","1234","별명",GENDER.FEMALE,"student", STATUS.ACTIVE,now(),"00",LocalDate.of(1999, 10, 9),3000L);

        User user = userDto.toEntity();

        //when
        Long savedId = userService.save(user);


        //then
//        em.flush();
        Assert.assertEquals("유저를 저장하면 저장된 회원과 입력한 회원이 일치해야 함",user,userService.findOne(savedId));
    }

    @Test
//    @Rollback(false)
    public void user_update() throws Exception{
        //given
        UserDto userDto = new UserDto("아이디","변경된 이름","변경된 비밀번호","변경된 별명", GENDER.FEMALE, "student", STATUS.ACTIVE, now(), "00", LocalDate.of(1999, 10, 9), 3000L);

//        //when
        Long assetId = userService.updateUser(3L, userDto);

        //then
        Assert.assertEquals("변경된 이름", userService.findOne(3L).getName());
    }



}