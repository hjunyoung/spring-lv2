package com.example.springlv2.entity.borrowRecord;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "borrow_record")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BorrowRecord extends BorrowRecordTimestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(name = "book_id", nullable = false)
    private Long bookId;

    @Column(name = "return_status", nullable = false)
    private boolean returnStatus;

    public BorrowRecord(Long memberId, Long bookId) {
        this.memberId = memberId;
        this.bookId = bookId;
        this.returnStatus = false;
    }

    public void returnBook() {
        this.returnStatus = true;
    }
}
