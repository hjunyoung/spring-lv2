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
        // Todo 중복 유효성 체크 추가하기
        try {
            memberRepository.save(member);
        } catch (Exception e) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다");
        }

        return new MemberResponseDto(member);
    }
}
