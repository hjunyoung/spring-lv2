package com.example.springlv2.controller;

import com.example.springlv2.dto.member.MemberRequestDto;
import com.example.springlv2.dto.member.MemberResponseDto;
import com.example.springlv2.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping()
    public ResponseEntity<MemberResponseDto> register(
        @RequestBody MemberRequestDto memberRequestDto) {
        MemberResponseDto memberResponseDto = memberService.register(memberRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(memberResponseDto);
//        return ResponseEntity.created().body(memberResponseDto);
    }


}
