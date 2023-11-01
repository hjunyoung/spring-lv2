package com.example.springlv2.entity.member;


import com.example.springlv2.dto.member.MemberRequestDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    // 유효성 검사 추가하기
    @Column(name = "gender", nullable = false, length = 1)
    private String gender;

    // 유효성 검사 추가하기
    @Column(name = "resident_registration_number", nullable = false, length = 13, unique = true)
    private String rrn;

    // 유효성 검사 추가하기
    @Column(name = "phone_number", nullable = false, length = 11, unique = true)
    private String phoneNumber;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "penalty_end_date")
    private LocalDate penaltyEndDate;

    public Member(MemberRequestDto memberRequestDto) {
        this.name = memberRequestDto.getName();
        this.gender = memberRequestDto.getGender();
        this.rrn = memberRequestDto.getRrn();
        this.phoneNumber = memberRequestDto.getPhoneNumber();
        this.address = memberRequestDto.getAddress();
    }

    public void penalize() {
        this.penaltyEndDate = LocalDate.now().plusDays(14);
    }
}
