package com.bibimbob.cashcow.controller;

import com.bibimbob.cashcow.domain.User;
import com.bibimbob.cashcow.dto.ChatBotDto.RequestDto;
import com.bibimbob.cashcow.dto.UserAssetsDto.DepositDto;
import com.bibimbob.cashcow.dto.UserAssetsDto.SavingDto;
import com.bibimbob.cashcow.feign.DialogFlowFeign;
import com.bibimbob.cashcow.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = {"챗봇 API"})
@RequiredArgsConstructor
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST})
public class ChatbotController {

    private final UserService userService;
    private final DialogFlowFeign dialogFlowFeign;
    /**
     *  유저가 string 으로 챗봇 요청
     */
    @ApiOperation(value = "회원 예금 정보 입력", notes = "해당 회원의 예금 정보를 받는 API입니다.")
    @PostMapping("/chatbot/request")
    public String updateAssets(@RequestBody RequestDto requestDto) throws Exception {
        // dialog server에 post 요청
        String response=dialogFlowFeign.dialog_flow(requestDto);

        return response;
    }

    /**
     * 예금 정보 입력 후 DIALOG-FLOW
     */
    @ApiOperation(value = "회원 예금 정보 입력", notes = "해당 회원의 예금 정보를 받는 API입니다.")
    @PostMapping("/deposit/{userId}")
    public void updateDeposit(@PathVariable("userId") Long id, @RequestBody DepositDto depositDto) throws Exception {
        User user = userService.findOne(id);
        // TO - DO
        // dialog server에 post 요청
    }

    /**
     * 적금 정보 입력 후 DIALOG-FLOW
     */
    @ApiOperation(value = "회원 적금 정보 입력", notes = "해당 회원의 적금 정보를 받는 API입니다.")
    @PostMapping("/saving/{userId}")
    public void updateAssets(@PathVariable("userId") Long id, @RequestBody SavingDto savingDto) throws Exception {
        User user = userService.findOne(id);
        // TO - DO
        // dialog server에 post 요청

    }



}
