package com.bibimbob.cashcow.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class test {
    private String userId="TEST";
    private String name="TEST";
    private String password="TEST";
    private String nickname="TEST";
    private String gender="TEST";
    private String job="TEST";
    private String status="TEST";
    private String phoneNumber="TEST";
    private LocalDateTime birth = LocalDateTime.now();
}
