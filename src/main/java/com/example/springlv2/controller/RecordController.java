package com.example.springlv2.controller;

import com.example.springlv2.dto.BorrowRecordDto;
import com.example.springlv2.service.RecordService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/books/records")
@RequiredArgsConstructor
public class RecordController {

    private final RecordService recordService;

    @GetMapping()
    public ResponseEntity<List<BorrowRecordDto>> showBorrowRecord(
        @RequestParam(name = "onloan", required = false) Optional<Boolean> onLoan) {
        List<BorrowRecordDto> record = recordService.showBorrowRecord(onLoan);
        return ResponseEntity.ok().body(record);
    }
}
