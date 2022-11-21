package com.bibimbob.cashcow.dto.stock;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "주식 정보", description = "주식 정보를 가진 Domain Class")
public class StockDto {
    @JsonProperty("response")
    private Response response;

    public static class Response {
        @JsonProperty("body")
        private Body body;
        @JsonProperty("header")
        private Header header;
    }

    public static class Body {
        @JsonProperty("items")
        private Items items;
        @JsonProperty("totalCount")
        private int totalcount;
        @JsonProperty("pageNo")
        private int pageno;
        @JsonProperty("numOfRows")
        private int numofrows;
    }

    public static class Items {
        @JsonProperty("item")
        private List<Item> item;
    }

    public static class Item {
        @JsonProperty("mrktTotAmt")
        private String mrkttotamt;
        @JsonProperty("lstgStCnt")
        private String lstgstcnt;
        @JsonProperty("trPrc")
        private String trprc;
        @JsonProperty("trqu")
        private String trqu;
        @JsonProperty("lopr")
        private String lopr;
        @JsonProperty("hipr")
        private String hipr;
        @JsonProperty("mkp")
        private String mkp;
        @JsonProperty("fltRt")
        private String fltrt;
        @JsonProperty("vs")
        private String vs;
        @JsonProperty("clpr")
        private String clpr;
        @JsonProperty("mrktCtg")
        private String mrktctg;
        @JsonProperty("itmsNm")
        private String itmsnm;
        @JsonProperty("isinCd")
        private String isincd;
        @JsonProperty("srtnCd")
        private String srtncd;
        @JsonProperty("basDt")
        private String basdt;
    }

    public static class Header {
        @JsonProperty("resultMsg")
        private String resultmsg;
        @JsonProperty("resultCode")
        private String resultcode;
    }
}
