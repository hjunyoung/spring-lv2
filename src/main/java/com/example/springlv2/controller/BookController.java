package com.example.springlv2.controller;

import com.example.springlv2.dto.ResponseDto;
import com.example.springlv2.dto.book.BookRequestDto;
import com.example.springlv2.dto.book.BookResponseDto;
import com.example.springlv2.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping()
    public ResponseEntity<BookResponseDto> addBook(
        @RequestBody @Validated BookRequestDto bookRequestDto) {
        BookResponseDto bookResponseDto = bookService.addBook(bookRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookResponseDto);
    }

    @GetMapping()
    public ResponseEntity<List<BookResponseDto>> getAllBook() {
        List<BookResponseDto> allBook = bookService.getAllBook();
        return ResponseEntity.status(HttpStatus.OK).body(allBook);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookResponseDto> getBook(@PathVariable long bookId) {
        BookResponseDto book = bookService.getBook(bookId);
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @PostMapping("{bookId}/members/{memberId}")
    public ResponseEntity<ResponseDto> borrowBook(@PathVariable Long bookId,
        @PathVariable Long memberId) {
        ResponseDto responseDto = bookService.borrowBook(memberId, bookId);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @PutMapping("{bookId}/members/{memberId}")
    public ResponseEntity<ResponseDto> returnBook(@PathVariable Long bookId,
        @PathVariable Long memberId) {
        ResponseDto responseDto = bookService.returnBook(memberId, bookId);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }
}
