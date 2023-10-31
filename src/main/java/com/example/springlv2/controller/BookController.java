package com.example.springlv2.controller;

import com.example.springlv2.dto.BookRequestDto;
import com.example.springlv2.dto.BookResponseDto;
import com.example.springlv2.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping()
    public ResponseEntity<BookResponseDto> addBook(@RequestBody BookRequestDto bookRequestDto) {
        BookResponseDto bookResponseDto = bookService.addBook(bookRequestDto);
        return ResponseEntity.status(201).body(bookResponseDto);
    }

    @GetMapping()
    public ResponseEntity<List<BookResponseDto>> getAllBook() {
        List<BookResponseDto> allBook = bookService.getAllBook();
        return ResponseEntity.status(200).body(allBook);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookResponseDto> getBook(@PathVariable Long bookId) {
        BookResponseDto book = bookService.getBook(bookId);
        return ResponseEntity.status(200).body(book);
    }
}
