package com.bibimbob.cashcow.controller;

import com.bibimbob.cashcow.dto.*;
import com.bibimbob.cashcow.dto.openbanking.*;
import com.bibimbob.cashcow.feign.OpenBankingFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
@Slf4j
@Api(tags = {"오픈뱅킹 API"})
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST})
public class OpenbankingController {

    private final OpenBankingFeign openBankingFeign;
    @Value("${client_secret}")
    private String client_secret;



    // 임시 회원가입 페이지 로드

    @GetMapping("/signup")
    public ModelAndView signup(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("MemberDto", new UserDto());
        mv.setViewName("signup");
        return mv;
    }


    // 토큰 발급 api
    @ApiOperation(value = "토큰 발급", notes = "토큰 요청을 위한 정보가 들어오면 토큰을 발급받아 응답을 제공하는 API입니다.")
    @PostMapping("/requestToken")
    public TokenResponseDto requestToken(@RequestBody TokenRequestDto tokenRequestDto) {
        tokenRequestDto.setClient_secret(client_secret);
        TokenResponseDto tokenResponseDto = openBankingFeign.requestToken(tokenRequestDto.getCode(), tokenRequestDto.getClient_id(), tokenRequestDto.getClient_secret(), tokenRequestDto.getRedirect_uri(), tokenRequestDto.getGrant_type());
        return tokenResponseDto;
    }

    // 등록계좌조회 api
    @ApiOperation(value = "등록 계좌 조회", notes = "등록된 계좌를 조회하는 API 입니다.")
    @GetMapping("/account/list")
    public AccountListDto getAccountList(String access_token, String user_seq_no, String include_cancel_yn, String sort_order){
        AccountListDto accountListDto = openBankingFeign.getAccountList("Bearer "+access_token,user_seq_no,include_cancel_yn,sort_order);
        return accountListDto;
    }

    // 잔액조회(등록된 fin번호로) api
    @ApiOperation(value = "잔액 조회", notes = "등록된 fin 번호로 각 계좌의 잔액을 조회하는 API 입니다.")
    @GetMapping("/account/balance/fin_num")
    public AccountBalanceDto getAccountBalance(String access_token, String bank_tran_id, String fintech_use_num, String tran_dtime){
        AccountBalanceDto accountBalanceDto = openBankingFeign.getBalance("Bearer "+access_token, bank_tran_id,fintech_use_num,tran_dtime);
        return accountBalanceDto;
    }

    // 거래내역 조회
    @ApiOperation(value = "거래내역 조회", notes = "등록된 fin번호로 사용자가 등록한 계좌의 거래내역을 조회하는 API 입니다.")
    @GetMapping("/account/transaction_list")
    public TransactionListDto getTransactionList(String access_token, String bank_tran_id, String fintech_use_num, String inquiry_type, String inquiry_base, String from_date, String to_date, String sort_order, String tran_dtime){
        TransactionListDto transactionListDto = openBankingFeign.getTransactionList("Bearer "+access_token, bank_tran_id, fintech_use_num, inquiry_type, inquiry_base, from_date, to_date, sort_order, tran_dtime);
        return transactionListDto;
    }




}
