package com.bibimbob.cashcow.controller;


import com.bibimbob.cashcow.domain.ChatResponse;
import com.bibimbob.cashcow.dto.ChatBotDto.ResponseDto;
import com.bibimbob.cashcow.dto.TestDto;
import com.bibimbob.cashcow.dto.UserDto;

import com.bibimbob.cashcow.feign.FASTFeign;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequiredArgsConstructor
public class TestController {

    private final FASTFeign fastFeign;

    @PostMapping("/request")
    public ResponseDto getApi(@RequestBody TestDto testDto){
        String response=fastFeign.dialog_flow(testDto);
        ChatResponse chatEnum = ChatResponse.RESPONSE;
        ResponseDto responseDto = new ResponseDto(chatEnum,response);
        return responseDto;

    }


}