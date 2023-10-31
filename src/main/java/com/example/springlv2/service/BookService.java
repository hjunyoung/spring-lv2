package com.example.springlv2.service;

import com.example.springlv2.dto.BookRequestDto;
import com.example.springlv2.dto.BookResponseDto;
import com.example.springlv2.entity.Book;
import com.example.springlv2.repository.BookRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public BookResponseDto addBook(BookRequestDto bookRequestDto) {
        // RequestDto -> Entity
        Book book = new Book(bookRequestDto);

        // DB에 저장
        Book savedBook = bookRepository.save(book);

        // Entity -> ResponseDto
        return new BookResponseDto(savedBook);
    }

    public List<BookResponseDto> getAllBook() {
        return bookRepository.findAllByOrderByRegisteredAtAsc().stream()
            .map(BookResponseDto::new).toList();
    }

    public BookResponseDto getBook(Long bookId) {
        // Entity 존재 확인
        Book book = bookRepository.findById(bookId).orElseThrow(() ->
            new IllegalArgumentException("선택한 게시물이 존재하지 않습니다.")
        );

        // Entity -> ResponseDto
        return new BookResponseDto(book);
    }
}
