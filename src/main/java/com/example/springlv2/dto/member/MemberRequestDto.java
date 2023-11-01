package com.example.springlv2.dto.member;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@Getter
public class MemberRequestDto {

    @NotBlank(message = "이름을 입력하세요")
    @Length(max = 100, message = "이름은 100자를 넘을 수 없습니다.")
    private String name;
    @NotBlank(message = "이름을 입력하세요")
    @Length(max = 1, message = "M,F 중 하나를 입력하세요")
    private String gender; // char로 해도 되나?
    @NotBlank(message = "주민번호를 입력하세요")
    @Pattern(regexp = "\\d{2}([0]\\d|[1][0-2])([0][1-9]|[1-2]\\d|[3][0-1])\\d{7}", message = "- 없이 입력하세요")
    private String rrn;
    @NotBlank(message = "전화번호를 입력하세요")
    @Pattern(regexp = "0\\d{9,13}", message = "- 없이 입력하세요")
    private String phoneNumber;
    @NotBlank(message = "주소를 입력하세요")
    private String address;
}
