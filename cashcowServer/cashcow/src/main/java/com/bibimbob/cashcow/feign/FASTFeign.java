package com.bibimbob.cashcow.feign;

import com.bibimbob.cashcow.dto.TestDto;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="FASTFeign", url="http://203.252.157.78:8080")
public interface FASTFeign {
    @PostMapping(path = "/dialog-flow")
    public String dialog_flow(
            @RequestBody TestDto testDto);
}
