package com.example.springlv2.dto.book;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@Getter
public class BookRequestDto {

    @NotBlank(message = "제목을 입력하세요")
    @Length(max = 255, message = "입력 가능한 글자 수를 초과했습니다")
    private String title;
    @NotBlank(message = "저자 이름를 입력하세요")
    @Length(max = 100, message = "입력 가능한 글자 수를 초과했습니다.")
    private String author;
    @Length(min = 2, max = 2, message = " ISO 639-1 codes 코드 형식으로 입력하세요") // Dropdown으로 해결
    private String language;
    @NotBlank(message = "출판사를 입력하세요")
    @Length(max = 255, message = "입력 가능한 글자 수를 초과했습니다.")
    private String publisher;
}
