package com.bibimbob.cashcow.controller;

import com.bibimbob.cashcow.domain.User;
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
    public User join(@RequestBody UserDto userDto) throws Exception{
        User savedUser = userService.save(userDto);
        return savedUser;
    }


    // id로 회원 찾기
    @ApiOperation(value = "회원 조회", notes = "유저 id로 회원을 조회하는 API입니다.")
    @GetMapping("/getUser/{id}")
    public UserDto getUser(@PathVariable("id") String id) throws Exception{
        UserDto userDto = userService.getUser(Long.parseLong(id));
        return userDto;
    }
}
