package com.bibimbob.cashcow.controller;

import com.bibimbob.cashcow.domain.ChatResponse;
import com.bibimbob.cashcow.dto.ChatBotRequestDto.RequestDepositDto;
import com.bibimbob.cashcow.dto.ChatBotResponseDto.ResponseDepositDto;
import com.bibimbob.cashcow.dto.ChatBotResponseDto.ResponseDto;
import com.bibimbob.cashcow.domain.User;
import com.bibimbob.cashcow.dto.ChatBotRequestDto.RequestDto;
import com.bibimbob.cashcow.dto.UserAssetsDto.DepositDto;
import com.bibimbob.cashcow.dto.UserAssetsDto.LoanDto;
import com.bibimbob.cashcow.dto.UserAssetsDto.SavingDto;
import com.bibimbob.cashcow.dto.UserDto;
import com.bibimbob.cashcow.feign.DialogFlowFeign;
import com.bibimbob.cashcow.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @ApiOperation(value = "회원 챗봇 요청", notes = "챗봇 요청 메시지를 dialog-flow 서버에 보내는 API입니다.")
    @PostMapping("/chatbot/request")
    public ResponseDto updateAssets(@RequestBody RequestDto requestDto) throws Exception {
        // dialog server에 post 요청
        String response=dialogFlowFeign.dialog_flow(requestDto).replaceAll("\"","");
        ResponseDto dialogflowResponse = new ResponseDto(ChatResponse.NORMAL, response);

        return dialogflowResponse;
    }

    /**
     * 예금 정보 입력 후 DIALOG-FLOW
     */
    @ApiOperation(value = "회원 예금 정보 입력", notes = "해당 회원의 예금 정보를 받는 API입니다.")
    @PostMapping("/deposit")
    public List<ResponseDepositDto> updateDeposit( @RequestBody DepositDto depositDto) throws Exception {

        // 유저 찾기 -> dto에 담기
        User findUser = userService.findOne(depositDto.getId());
        UserDto userDto = new UserDto(findUser.getUserId(), findUser.getName(), findUser.getPassword(),findUser.getNickname() ,findUser.getGender(), findUser.getJob(),findUser.getStatus(),findUser.getCreatedAt(),findUser.getModifiedAt(),findUser.getPhoneNumber(),findUser.getBirth(),findUser.getSalary() );

        // 예금 정보 + 유저 정보 합쳐 request 위한 dto 생성
        RequestDepositDto requestDepositDto = new RequestDepositDto(depositDto.getExpectedPeriod(), depositDto.getSavingAmount(), userDto);

        // feign 인터페이스로 POST 요청
        List<ResponseDepositDto> responseDepositDto = dialogFlowFeign.deposit_products_search(requestDepositDto);

        return responseDepositDto;
    }

    /**
     * 적금 정보 입력 후 DIALOG-FLOW
     */
    @ApiOperation(value = "회원 적금 정보 입력", notes = "해당 회원의 적금 정보를 받는 API입니다.")
    @PostMapping("/saving")
    public void updateAssets( @RequestBody SavingDto savingDto) throws Exception {
        User user = userService.findOne(savingDto.getId());
        // TO - DO
        // dialog server에 post 요청

    }

    /**
     * 대출 정보 입력 후 DIALOG-FLOW
     */
    @ApiOperation(value = "회원 대출 정보 입력", notes = "해당 회원의 대출 정보를 받는 API입니다.")
    @PostMapping("/loan}")
    public void updateLoan( @RequestBody LoanDto loanDto) throws Exception {
        User user = userService.findOne(loanDto.getId());
        // TO - DO
        // dialog server에 post 요청
    }



}
