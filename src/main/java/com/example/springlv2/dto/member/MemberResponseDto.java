package com.example.springlv2.dto.member;

import com.example.springlv2.entity.member.Member;
import lombok.Getter;

@Getter
public class MemberResponseDto {

    private final Long id;
    private final String name;
    private final String gender;
    private final String phoneNumber;
    private final String address;

    public MemberResponseDto(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.gender = member.getGender();
        this.phoneNumber = member.getPhoneNumber();
        this.address = member.getAddress();
    }
}
