package com.bibimbob.cashcow.controller;

import com.bibimbob.cashcow.domain.User;
import com.bibimbob.cashcow.dto.*;
import com.bibimbob.cashcow.feign.OpenBankingFeign;
import com.bibimbob.cashcow.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST})
public class APIController {

    private final OpenBankingFeign openBankingFeign;
    private final UserService userService;
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

    // 회원가입 (회원 DB에 SAVE)
    @PostMapping("/join")
    public User join(@RequestBody UserDto userDto) throws Exception{
        User savedUser = userService.save(userDto);
        return savedUser;
    }

    // 토큰 발급 api
    @PostMapping("/requestToken")
    public TokenResponseDto requestToken(@RequestBody TokenRequestDto tokenRequestDto) {
        tokenRequestDto.setClient_secret(client_secret);
        TokenResponseDto tokenResponseDto = openBankingFeign.requestToken(tokenRequestDto.getCode(), tokenRequestDto.getClient_id(), tokenRequestDto.getClient_secret(), tokenRequestDto.getRedirect_uri(), tokenRequestDto.getGrant_type());
        return tokenResponseDto;
    }

    // 등록계좌조회 api
    @GetMapping("/account/list")
    public AccountListDto getAccountList(String access_token, String user_seq_no, String include_cancel_yn, String sort_order){
        AccountListDto accountListDto = openBankingFeign.getAccountList("Bearer "+access_token,user_seq_no,include_cancel_yn,sort_order);
        return accountListDto;
    }

    // 잔액조회(등록된 fin번호로) api
    @GetMapping("/account/balance/fin_num")
    public AccountBalanceDto getAccountBalance(String access_token, String bank_tran_id, String fintech_use_num, String tran_dtime){
        AccountBalanceDto accountBalanceDto = openBankingFeign.getBalance("Bearer "+access_token, bank_tran_id,fintech_use_num,tran_dtime);
        return accountBalanceDto;
    }

    // 거래내역 조회
    @GetMapping("/account/transaction_list")
    public TransactionListDto getTransactionList(String access_token, String bank_tran_id, String fintech_use_num, String inquiry_type, String inquiry_base, String from_date, String to_date, String sort_order, String tran_dtime){
        TransactionListDto transactionListDto = openBankingFeign.getTransactionList("Bearer "+access_token, bank_tran_id, fintech_use_num, inquiry_type, inquiry_base, from_date, to_date, sort_order, tran_dtime);
        return transactionListDto;
    }




}
