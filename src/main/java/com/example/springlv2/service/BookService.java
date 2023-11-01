package com.example.springlv2.service;

import com.example.springlv2.dto.ResponseDto;
import com.example.springlv2.dto.book.BookRequestDto;
import com.example.springlv2.dto.book.BookResponseDto;
import com.example.springlv2.entity.book.Book;
import com.example.springlv2.entity.borrowRecord.BorrowRecord;
import com.example.springlv2.entity.member.Member;
import com.example.springlv2.repository.BookRepository;
import com.example.springlv2.repository.MemberRepository;
import com.example.springlv2.repository.RecordRepository;
import java.util.List;
import java.util.Optional;
import javax.naming.ServiceUnavailableException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final RecordRepository recordRepository;
    private final MemberRepository memberRepository;

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
        Book book = findBook(bookId);

        // Entity -> ResponseDto
        return new BookResponseDto(book);
    }

    @Transactional
    public ResponseDto borrowBook(Long memberId, Long bookId) {
        // Book 존재 확인
        Book book = findBook(bookId);

        // 회원 존재 확인
        memberCheck(memberId);

        // 반납할 도서가 있는지 확인
        Optional<BorrowRecord> bookToReturn = recordRepository.findFirstByMemberIdOrderByBorrowedAtDesc(
            memberId);
        if (bookToReturn.isPresent() && !bookToReturn.get().isReturnStatus()) {
            // 예외를 던지는 것과 Http status를 전달하는 것의 차이는?
            throw new IllegalArgumentException("현재 대출 중인 도서가 있습니다.");
        }

        // 책 빌릴 수 있는지 확인
        if (!book.isAvailable()) {
            // TODO 적절한 Exception으로 변경 후 controller에서 예외처리하기 + status code
            throw new IllegalArgumentException("선택한 도서를 빌릴 수 없습니다.");
        }

        // 도서 대출 가능 여부 변경
        book.updateAvailablily(false);

        // 대출 record 저장
        // BorrowRecord Entity
        BorrowRecord borrowRecord = new BorrowRecord(memberId, bookId);
        recordRepository.save(borrowRecord);

        return new ResponseDto(String.format("회원(%d): 도서(id %d) 대출 성공", memberId, bookId));
    }

    @Transactional
    public ResponseDto returnBook(Long memberId, Long bookId) {
        // 회원 존재 확인
        memberCheck(memberId);

        // 반납할 도서가 있는지 확인
        Optional<BorrowRecord> bookToReturn = recordRepository.
            findFirstByMemberIdAndBookIdOrderByBorrowedAtDesc(memberId, bookId);
        if (bookToReturn.isEmpty() || bookToReturn.get()
            .isReturnStatus()) {
            // 예외를 던지는 것과 Http status를 전달하는 것의 차이는?
            throw new IllegalArgumentException("해당 도서를 대출하지 않았습니다.");
        }

        // 대출 record 업데이트
        // BorrowRecord Entity
        bookToReturn.get().returnBook();

        // 도서 대출 가능 여부 변경
        Book book = findBook(bookId);
        book.updateAvailablily(true);

        return new ResponseDto(String.format("회원(%d): 도서(id %d) 반납 성공", memberId, bookId));
    }

    private Book findBook(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(() ->
            new IllegalArgumentException("선택한 도서가 존재하지 않습니다.")
        );
    }

    private void memberCheck(Long memberId) {
        memberRepository.findById(memberId).orElseThrow(() ->
            new IllegalArgumentException("회원 정보가 존재하지 않습니다.")
        );
    }
}
