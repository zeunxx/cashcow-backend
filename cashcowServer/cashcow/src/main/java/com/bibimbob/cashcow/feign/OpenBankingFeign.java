package com.bibimbob.cashcow.feign;

import com.bibimbob.cashcow.dto.AccountBalanceDto;
import com.bibimbob.cashcow.dto.AccountListDto;
import com.bibimbob.cashcow.dto.TokenResponseDto;
import com.bibimbob.cashcow.dto.TransactionListDto;
import org.hibernate.Transaction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="feign", url="https://testapi.openbanking.or.kr")
public interface OpenBankingFeign {
    @PostMapping(path = "/oauth/2.0/token", consumes = "application/x-www-form-urlencoded", produces = "application/json")
    public TokenResponseDto requestToken(
            @RequestParam("code") String code,
            @RequestParam("client_id") String client_id,
            @RequestParam("client_secret") String client_secret,
            @RequestParam("redirect_uri") String redirect_uri,
            @RequestParam("grant_type") String grant_type);


    @GetMapping(path="/v2.0/account/list")
    public AccountListDto getAccountList(
            @RequestHeader("Authorization") String access_token,
            @RequestParam("user_seq_no") String user_seq_no,
            @RequestParam("include_cancel_yn") String include_cancel_yn,
            @RequestParam("sort_order") String sort_order);

    @GetMapping(path = "/v2.0/account/balance/fin_num")
    public AccountBalanceDto getBalance(
            @RequestHeader("Authorization") String access_token,
            @RequestParam("bank_tran_id") String bank_tran_id,
            @RequestParam("fintech_use_num") String fintech_use_num,
            @RequestParam("tran_dtime") String tran_dtime);

    @GetMapping(path="/v2.0/account/transaction_list/fin_num")
    public TransactionListDto getTransactionList(
            @RequestHeader("Authorization") String access_token,
            @RequestParam("bank_tran_id") String bank_tran_id,
            @RequestParam("fintech_use_num") String fintech_use_num,
            @RequestParam("inquiry_type") String inquiry_type,
            @RequestParam("inquiry_base") String inquiry_base,
            @RequestParam("from_date") String from_date,
            @RequestParam("to_date") String to_date,
            @RequestParam("sort_order") String sort_order,
            @RequestParam("tran_dtime") String tran_dtime);


}
