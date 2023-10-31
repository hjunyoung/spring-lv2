package com.example.springlv2.dto.member;

import lombok.Getter;

@Getter
public class MemberRequestDto {

    private String name;
    private String gender; // char로 해도 되나?
    private String rrn;
    private String phoneNumber;
    private String address;
}
