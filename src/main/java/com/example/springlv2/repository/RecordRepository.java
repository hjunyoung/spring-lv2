package com.example.springlv2.repository;

import com.example.springlv2.entity.borrowRecord.BorrowRecord;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<BorrowRecord, Long> {

    List<BorrowRecord> findAllByOrderByBorrowedAtAsc();

    Optional<BorrowRecord> findFirstByMemberIdOrderByBorrowedAtDesc(Long memberId);

    Optional<BorrowRecord> findFirstByMemberIdAndBookIdOrderByBorrowedAtDesc(
        Long memberId,
        Long bookId
    );

}
