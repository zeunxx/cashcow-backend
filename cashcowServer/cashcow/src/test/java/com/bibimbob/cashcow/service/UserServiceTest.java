package com.bibimbob.cashcow.service;

import com.bibimbob.cashcow.domain.GENDER;
import com.bibimbob.cashcow.domain.STATUS;
import com.bibimbob.cashcow.domain.Stock.FavoriteStock;
import com.bibimbob.cashcow.domain.User;
import com.bibimbob.cashcow.dto.StockDto.UserStockDto;
import com.bibimbob.cashcow.dto.UserDto;
import com.bibimbob.cashcow.repository.UserRepository;
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
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;

import static java.time.LocalDateTime.now;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired UserService userService;
    @Autowired EntityManager em;
    @Autowired UserRepository userRepository;

    @Test
    public void 회원_한명_조회() throws Exception{
        //given
        Long userId = 6L;

        //when
        User user = userService.findOne(userId);

        //then
        System.out.println(user.getName());
        Assert.assertEquals(6,user.getId());
    }

    @Test
//    @Rollback(false)
    public void 회원_가입() throws Exception{
        //given
        UserDto userDto = new UserDto("new_new_Id","이름","1234","별명",GENDER.FEMALE,"student", STATUS.ACTIVE,null,null,"00",LocalDate.of(1999, 10, 9),3000L);

        User user = userDto.toEntity();

        //when
        Long savedId = userService.save(user);


        //then
        Assert.assertEquals("유저를 저장하면 저장된 회원과 입력한 회원이 일치해야 함",user,userService.findOne(savedId));

    }

    @Test
//    @Rollback(false)
    public void 회원수정() throws Exception{
        //given
        UserDto userDto = new UserDto("new_Id","변경된 이름3","변경된 비밀번호","변경된 별명", GENDER.FEMALE, "student", STATUS.ACTIVE,null ,null, "00", LocalDate.of(1999, 10, 9), 3000L);


        //when
        Long assetId = userService.updateUser(userDto);

        //then
        Assert.assertEquals("변경된 이름3", userService.findOne(assetId).getName());
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


    @Test
//    @Rollback(false)
    public void 즐겨찾기_저장() throws Exception{
        //given
        UserStockDto userStockDto = new UserStockDto(6L, 12345L);

        //when
        Long aLong = userService.saveStock(userStockDto);

        //then
        Assert.assertEquals(Optional.of(userStockDto.getUserPk()), Optional.of(aLong));
    }

    @Test
//    @Rollback(false)
    public void 즐겨찾기_삭제() throws Exception{
        //given
        UserStockDto userStockDto = new UserStockDto(6L, 12345L);

        //when
        Long aLong = userService.removeStock(userStockDto);

        //then
        Assert.assertEquals(Optional.of(userStockDto.getUserPk()),Optional.of(aLong));
    }

    @Test
//    @Rollback(false)
    public void 즐겨찾기_없는객체_삭제() throws Exception{
        //given
        UserStockDto userStockDto = new UserStockDto(4L, 54430L);

        //when
        Long aLong = userService.removeStock(userStockDto);

        //then
//        Assert.assertEquals(0, Optional.ofNullable(aLong));
    }

    @Test
    public void 즐겨찾기_중복_방지() throws Exception{
        //given
        UserDto userDto = new UserDto("new_newId!","이름","1234","별명",GENDER.FEMALE,"student", STATUS.ACTIVE,null,now(),"00",LocalDate.of(1999, 10, 9),3000L);
        User user = userDto.toEntity();
        Long savedId = userService.save(user);

        UserStockDto userStockDto = new UserStockDto(savedId, 54430L);
        UserStockDto userStockDto2 = new UserStockDto(savedId, 54430L);
        Long aLong = userService.saveStock(userStockDto);

        //when
        Long aLong2 = userService.saveStock(userStockDto2);
        List<FavoriteStock> oneStock = userRepository.findOneStock(savedId, 54430l);


        //then
        Assert.assertEquals(1,oneStock.size());
    }

    @Test
    public void 즐겨찾기_리스트_get() throws Exception{
        //given
        List<FavoriteStock> stockList = userService.getStockList(6L);

        //when
        for (FavoriteStock favoriteStock : stockList) {
            System.out.println("favoriteStock = " + favoriteStock);
        }

        //then
        Assert.assertEquals(2,stockList.size());

    }
    /**
     * 즐겨찾기 없는객체 저장 방지
     */
}