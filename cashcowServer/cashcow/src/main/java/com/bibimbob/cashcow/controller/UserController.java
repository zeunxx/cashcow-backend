package com.bibimbob.cashcow.controller;

import com.bibimbob.cashcow.domain.User;
import com.bibimbob.cashcow.dto.UserAssetsDto;
import com.bibimbob.cashcow.dto.UserDto;
import com.bibimbob.cashcow.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = {"유저 API"})
@RequiredArgsConstructor
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST})
public class UserController {

    private final UserService userService;

    // 회원가입 (회원 DB에 SAVE)
    @ApiOperation(value = "회원 가입", notes = "유저 정보를 입력받아 회원 DB에 저장하는 API입니다.")
    @PostMapping("/join")
    public void join(@RequestBody UserDto userDto) throws Exception{
        // dto to entity
        User user = userDto.toEntity();
        userService.save(user);
    }


    // id로 회원 찾기
    @ApiOperation(value = "회원 조회", notes = "유저 id로 회원을 조회하는 API입니다.")
    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") Long id) throws Exception{
        User user = userService.findOne(id);
        return user;
    }

    // 자산 정보 update
    @ApiOperation(value = "회원 자산 정보 업데이트", notes = "해당 회원의 자산 정보를 수정하는 API입니다.")
    @PostMapping("/updateAssets/{userId}")
    public void updateAssets(@PathVariable("userId") Long id, UserAssetsDto userAssetsDto) throws Exception{
        User user = userService.findOne(id);
        userService.updateAssets(user.getUserAsset().getId(), userAssetsDto);
    }
}
