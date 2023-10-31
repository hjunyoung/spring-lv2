package com.example.springlv2.service;

import com.example.springlv2.dto.member.MemberRequestDto;
import com.example.springlv2.dto.member.MemberResponseDto;
import com.example.springlv2.entity.member.Member;
import com.example.springlv2.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberResponseDto register(MemberRequestDto memberRequestDto) {
        // RequestDto -> Entity
        Member member = new Member(memberRequestDto);

        // DB 저장
        // TODO 예외 던지고 @ControllerAdvice, @ExceptionHandler로 예외처리하기
        memberRepository.save(member);

        return new MemberResponseDto(member);
    }
}
