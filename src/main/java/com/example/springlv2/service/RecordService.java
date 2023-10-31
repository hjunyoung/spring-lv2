package com.example.springlv2.service;

import com.example.springlv2.dto.BorrowRecordDto;
import com.example.springlv2.entity.book.Book;
import com.example.springlv2.entity.borrowRecord.BorrowRecord;
import com.example.springlv2.entity.member.Member;
import com.example.springlv2.repository.BookRepository;
import com.example.springlv2.repository.MemberRepository;
import com.example.springlv2.repository.RecordRepository;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecordService {

    private final RecordRepository recordRepository;
    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;

    public List<BorrowRecordDto> showBorrowRecord() {
        return recordRepository.findAllByOrderByBorrowedAtAsc()
            .stream().map(this::mapToBorrowRecordDto)
            .toList();
    }

    private BorrowRecordDto mapToBorrowRecordDto(BorrowRecord borrowRecord) {
        Long id = borrowRecord.getId();
        LocalDateTime borrowedAt = borrowRecord.getBorrowedAt();
        Member member = memberRepository.findById(borrowRecord.getMemberId()).get();
        Book book = bookRepository.findById(borrowRecord.getBookId()).get();
        String name = member.getName();
        String phoneNumber = member.getName();
        String title = book.getTitle();
        String author = book.getAuthor();
        return new BorrowRecordDto(
            id,
            name,
            phoneNumber,
            title,
            author,
            borrowedAt);
    }
}
