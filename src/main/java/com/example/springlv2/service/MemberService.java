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
        // TODO Validate로 바꾸면 어떻게 되지?
        // Exception으로 받는게 좀 이상함
        try {
            memberRepository.save(member);
        } catch (Exception e) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다");
        }

        return new MemberResponseDto(member);
    }
}
