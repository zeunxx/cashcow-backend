package com.bibimbob.cashcow.service;

import com.bibimbob.cashcow.domain.GENDER;
import com.bibimbob.cashcow.domain.User;
import com.bibimbob.cashcow.domain.UserAssets;
import com.bibimbob.cashcow.dto.UserAssetsDto;
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
import javax.swing.text.html.parser.Entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired UserService userService;
    @Autowired
    EntityManager em;

    @Test
    public void 회원_조회() throws Exception{
        //given
        Long userId = 1L;

        //when
        User user = userService.findOne(userId);

        //then
        Assert.assertEquals(1,user.getId());
    }

    @Test
//    @Rollback(false)
    public void 회원_저장() throws Exception{
        //given

        /**
         * 자산 정보 안넣고 회원 가입 성공
          */
        UserAssets userAsset = UserAssets.builder().build();
        User user = User.builder().name("test").gender(GENDER.FEMALE).phoneNumber("00").password("12")
                .job("st").status("none").nickname("zeun").userAsset(userAsset)
                .build();


        /**
         * 자산 정보 넣고 회원 가입
         */
        UserAssets userAsset2 = new UserAssets(100,100,100,now(),now());
        User user2 = User.builder().name("test2").gender(GENDER.FEMALE).phoneNumber("00").password("12")
                .job("st").status("none").nickname("zeun").userAsset(userAsset2)
                .build();

        //when
        Long savedId = userService.save(user2);


        //then
//        em.flush();
        Assert.assertEquals("유저를 저장하면 저장된 회원과 입력한 회원이 일치해야 함",user2,userService.findOne(savedId));
    }

    @Test
    @Rollback(false)
    public void 유저_자산_추가입력() throws Exception{
        //given
        UserAssetsDto userAssetsDto = new UserAssetsDto(null,null,null);

        //when
        Long assetId = userService.updateAssets(2L, userAssetsDto);

        //then
        Long wantTotal = userService.findOne(2L).getUserAsset().getTotalHoldings();
        Long realTotal = userAssetsDto.getTotalHoldings();
        Assert.assertEquals(realTotal, wantTotal);
    }

    @Test
    public void a() throws Exception{
        //given

        //when

        //then
    }

}