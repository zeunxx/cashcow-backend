package com.bibimbob.cashcow.service;

import com.bibimbob.cashcow.domain.GENDER;
import com.bibimbob.cashcow.domain.STATUS;
import com.bibimbob.cashcow.domain.Stock.FavoriteStock;
import com.bibimbob.cashcow.domain.User;
import com.bibimbob.cashcow.dto.StockDto.UserStockDto;
import com.bibimbob.cashcow.dto.User.UserDto;
import com.bibimbob.cashcow.repository.StockJpaRepository;
import com.bibimbob.cashcow.repository.UserJpaRepository;
import org.hibernate.type.TrueFalseType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.test.context.SpringBootTest;
import static java.time.LocalDateTime.now;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired UserService userService;
    @Autowired UserJpaRepository userJpaRepository;
    @Autowired StockJpaRepository stockJpaRepository;
    @Autowired EntityManager em;
    @Autowired PasswordEncoder passwordEncoder;

    PageRequest pageRequest = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "stockCode"));

    @Test
    public void 회원_한명_조회() throws Exception{
        //given
        Long userId = 70L;

        //when
        User user = userService.findOne(userId);

        //then
        System.out.println(user.getName());
        System.out.println("user.getPassword() = " + user.getPassword());
        Assert.assertEquals(70,user.getId());
    }

    @Test
//    @Rollback(false)
    public void 회원_가입() throws Exception{
        //given
        UserDto userDto = new UserDto("0329-2","이름","0329-2","별명",GENDER.FEMALE,"student", STATUS.ACTIVE,null,null,"00",LocalDate.of(1999, 10, 9),3000L);

        User user = userDto.toEntity();

        //when
        Long savedId = userService.save(user);


        //then
        Assert.assertEquals("유저를 저장하면 저장된 회원과 입력한 회원이 일치해야 함",user,userService.findOne(savedId));

    }

    @Test
//    @Rollback(false)
    public void 회원_비밀번호_수정() throws Exception{
        //given
        String newPass = "newPw";
        long userId = 91L;
        //when
        Long assetId = userService.updatePw(userId, newPass);
        User findUser = userService.findOne(userId);

        String findPassword = findUser.getPassword();

        //then
        boolean result = passwordEncoder.matches(newPass, findPassword);
        Assert.assertEquals(true, result);
    }

    @Test
//    @Rollback(false)
    public void 회원수정() throws Exception{
        //given
        UserDto userDto = new UserDto("testetse","이름 변경@@@","newnewnew","변경된 별명", GENDER.FEMALE, "student", STATUS.ACTIVE,null ,null, "00", LocalDate.of(1999, 10, 9), 3000L);


        //when
        Long assetId = userService.updateUser(userDto);

        //then

        Assert.assertEquals("이름 변경@@@", userService.findOne(assetId).getName());
    }
    
    @Test(expected = IllegalStateException.class)
    public void 중복_회원_아이디_예외() throws Exception{
        //given
        UserDto userDto = new UserDto("new_id","이름","1234","별명",GENDER.FEMALE,"student", STATUS.ACTIVE,null,now(),"00",LocalDate.of(1999, 10, 9),3000L);
        User user = userDto.toEntity();
        UserDto userDto2 = new UserDto("new_id","중복된회원입니다","1234","별명",GENDER.FEMALE,"student", STATUS.ACTIVE,null,now(),"00",LocalDate.of(1999, 10, 9),3000L);
        User user2 = userDto.toEntity();

        //when
        Long save = userService.save(user);
        Long save2 = userService.save(user2);

        //then
        fail("예외가 발생해야 한다.");
    }

    @Test(expected = IllegalStateException.class)
    public void 탈퇴() throws Exception{
        //given
        long userId = 6L;

        //when
        userService.deleteUser(userId);
        User findUser = userService.findOne(userId);

        //then
        fail("예외가 발생해야 함");
    }

    @Test
//    @Rollback(false)
    public void 탈퇴_주식즐겨찾기_삭제() throws Exception{
        //given
        long userId = 6L;

        //when
        userService.deleteUser(userId);
        Page<FavoriteStock> findStockList = stockJpaRepository.findByUserPk(pageRequest,userId);

        //then
        assertEquals(0, findStockList.getTotalElements());
    }

    @Test
//    @Rollback(false)
    public void 즐겨찾기_저장() throws Exception{
        //given
        UserStockDto userStockDto = new UserStockDto(6L, "0014");

        //when
        Long aLong = userService.saveStock(userStockDto);

        //then
        Assert.assertEquals(Optional.of(userStockDto.getUserPk()), Optional.of(aLong));
    }

    @Test
//    @Rollback(false)
    public void 즐겨찾기_삭제() throws Exception{
        //given
        UserStockDto userStockDto = new UserStockDto(37L, "1234");

        //when
        Long aLong = userService.removeStock(userStockDto);

        //then
        Assert.assertEquals(Optional.of(userStockDto.getUserPk()),Optional.of(aLong));
    }

    @Test
//    @Rollback(false)
    public void 즐겨찾기_없는객체_삭제() throws Exception{
        //given
        UserStockDto userStockDto = new UserStockDto(4L, "54430");

        //when
        Long aLong = userService.removeStock(userStockDto);

        //then
//        Assert.assertEquals(0, Optional.ofNullable(aLong));
    }

    @Test(expected = IllegalStateException.class)
    public void 즐겨찾기_중복_방지() throws Exception{
        //given
        UserDto userDto = new UserDto("new_newId!","이름","1234","별명",GENDER.FEMALE,"student", STATUS.ACTIVE,null,now(),"00",LocalDate.of(1999, 10, 9),3000L);
        User user = userDto.toEntity();
        Long savedId = userService.save(user);

        UserStockDto userStockDto = new UserStockDto(savedId, "98765");
        UserStockDto userStockDto2 = new UserStockDto(savedId, "98765");
        Long aLong = userService.saveStock(userStockDto);

        //when
        Long aLong2 = userService.saveStock(userStockDto2);


        //then
        fail();
    }

    @Test
    public void 즐겨찾기_리스트_get() throws Exception{
        //given
        Page<FavoriteStock> stockList = userService.getStockList(pageRequest,37L);

        //when
        for (FavoriteStock favoriteStock : stockList) {
            System.out.println("favoriteStock = " + favoriteStock);
        }

        //then
        Assert.assertEquals(14,stockList.getTotalElements());

    }

    @Test
    @Rollback(false)
    public void 비밀번호암호화_회원가입() throws Exception{
        //given
        UserDto userDto = new UserDto("1234","이름","1234","별명",GENDER.FEMALE,"student", STATUS.ACTIVE,null,null,"00",LocalDate.of(1999, 10, 9),3000L);

        User user = userDto.toEntity();

        //when
        Long savedId = userService.save(user);


        //then
        Assert.assertEquals("유저를 저장하면 저장된 회원과 입력한 회원이 일치해야 함",user,userService.findOne(savedId));

    }



}