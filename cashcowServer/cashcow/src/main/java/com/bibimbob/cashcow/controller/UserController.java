package com.bibimbob.cashcow.controller;

import com.bibimbob.cashcow.Exception.ApiExceptionEntity;
import com.bibimbob.cashcow.domain.Stock.FavoriteStock;
import com.bibimbob.cashcow.domain.User;
import com.bibimbob.cashcow.dto.StockDto.ResponseStockDto;
import com.bibimbob.cashcow.dto.UserDto;
import com.bibimbob.cashcow.dto.StockDto.UserStockDto;
import com.bibimbob.cashcow.dto.UserResponseDto.ResponseIdCheckDto;
import com.bibimbob.cashcow.dto.UserResponseDto.ResponseSaveDto;
import com.bibimbob.cashcow.repository.UserRepository;
import com.bibimbob.cashcow.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

        // dto -> entity
        User user = userDto.toEntity();

        // save
        userService.save(user);
        return new ResponseSaveDto(user.getId());
    }


    // id로 회원 찾기
    @ApiOperation(value = "회원 조회", notes = "유저 pk로 회원을 조회하는 API입니다.")
    @GetMapping("/getUser")
    public UserDto getUser(Long id) throws Exception{
        User user = userService.findOne(id);
        return new UserDto(user);
    }


    // 유저 정보 update
    @ApiOperation(value = "회원 정보 업데이트", notes = "해당 회원의 정보를 수정하는 API입니다.")
    @PostMapping("/updateUser")
    public StatusResponse updateUser(@RequestBody  UserDto userDto, Exception e) throws Exception{
        // DB에 UPDATE
        userService.updateUser(userDto);
        return new StatusResponse(HttpStatus.OK);
    }

    // 즐겨찾기 주식 저장
    @ApiOperation(value = "회원 주식 즐겨찾기 저장 업데이트", notes = "해당 회원의 주식 즐겨찾기 저장하는 API입니다.")
    @PostMapping("/saveStock")
    public StatusResponse saveStock(@RequestBody UserStockDto userStockDto) throws Exception{
        // DB에 INSERT
        userService.saveStock(userStockDto);
        return new StatusResponse(HttpStatus.OK);
    }

    // 아이디 중복 체크
    @GetMapping("/idCheck")
    public ResponseIdCheckDto idCheck(String userId) throws Exception{
        return new ResponseIdCheckDto(userService.findById(userId));
    }

    // 즐겨찾기 주식 삭제
    @ApiOperation(value = "회원 주식 즐겨찾기 삭제", notes = "해당 회원의 주식 즐겨찾기 삭제하는 API입니다.")
    @PostMapping("/removeStock")
    public StatusResponse removeStock(@RequestBody UserStockDto userStockDto) throws Exception{
        // DB에 REMOVE
        userService.removeStock(userStockDto);
        return new StatusResponse(HttpStatus.OK);
    }

    // 즐겨찾기 주식 목록 GET
    @ApiOperation(value = "회원 주식 즐겨찾기 목록 조회", notes = "해당 회원의 주식 즐겨찾기 목록을 조회하는 API입니다.")
    @GetMapping("/getStock")
    public ResponseStockDto getStock( Long id) throws Exception{

        // DB에서 GET
        List<FavoriteStock> stockList = userService.getStockList(id);
        return new ResponseStockDto(stockList);
    }


    @Getter
    static class StatusResponse{
        private int status;

        public StatusResponse(HttpStatus status) {
            this.status = status.value();
        }
    }
}
