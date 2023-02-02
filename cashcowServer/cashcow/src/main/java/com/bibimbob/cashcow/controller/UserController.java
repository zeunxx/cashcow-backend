package com.bibimbob.cashcow.controller;

import com.bibimbob.cashcow.domain.User;
import com.bibimbob.cashcow.dto.UserDto;
import com.bibimbob.cashcow.dto.StockDto.UserStockDto;
import com.bibimbob.cashcow.dto.UserResponseDto.ResponseSaveDto;
import com.bibimbob.cashcow.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalDateTime.now;

@RestController
@Api(tags = {"유저 API"})
@RequiredArgsConstructor
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST})
public class UserController {

    private final UserService userService;

    // 회원가입 (회원 DB에 SAVE)
    @ApiOperation(value = "회원 가입", notes = "유저 정보를 입력받아 회원 DB에 저장하는 API입니다.")
    @PostMapping("/join")
    public ResponseSaveDto join(@RequestBody UserDto userDto) throws Exception{
        // dto to entity
        userDto.setCreatedAt(now());
        userDto.setModifiedAt(now());
        User user = userDto.toEntity();


        try{
            userService.save(user);
        }catch(Exception e){
            ResponseSaveDto responseSaveDto = new ResponseSaveDto(0L);
            return responseSaveDto;
        }
        ResponseSaveDto responseSaveDto = new ResponseSaveDto(user.getId());
        return responseSaveDto;
    }


    // id로 회원 찾기
    @ApiOperation(value = "회원 조회", notes = "유저 id로 회원을 조회하는 API입니다.")
    @GetMapping("/getUser")
    public User getUser(Long id) throws Exception{
        System.out.println("id = " + id);
        User user = userService.findOne(id);
        return user;
    }



    // 유저 정보 update
    @ApiOperation(value = "회원 정보 업데이트", notes = "해당 회원의 정보를 수정하는 API입니다.")
    @PostMapping("/updateUser")
    public void updateUser(UserDto userDto) throws Exception{
        userService.updateUser(userDto);
    }

    @ApiOperation(value = "회원 주식 즐겨찾기 저장 업데이트", notes = "해당 회원의 주식 즐겨찾기 저장하는 API입니다.")
    @PostMapping("/saveStock")
    public void saveStock(UserStockDto userStockDto) throws Exception{
        // TO-DO
         userService.saveStock(userStockDto);
        // DB에 ISNERT
    }

    @ApiOperation(value = "회원 주식 즐겨찾기 저장 업데이트", notes = "해당 회원의 주식 즐겨찾기 저장하는 API입니다.")
    @PostMapping("/removeStock")
    public void removeStock( UserStockDto userStockDto) throws Exception{
        // TO-DO
//        userService.removeStock(id, userStockDto);
        // DB에서 REMOVE
    }

    @ApiOperation(value = "회원 주식 즐겨찾기 목록 조회", notes = "해당 회원의 주식 즐겨찾기 목록을 조회하는 API입니다.")
    @GetMapping("/getStock")
    public void getStock( Long id) throws Exception{
        // TO-DO
        // DB에서 GET
    }
}
