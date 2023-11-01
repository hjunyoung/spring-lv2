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
@RequestMapping("api/records")
@RequiredArgsConstructor
public class RecordController {

    private final RecordService recordService;

    /**
     * 대출 내역 조회
     *
     * @param onLoan : 반납 완료된 대출 내역을 제외하고 조회할지 선택하는 옵션 true이면 반납 완료 대출 내역은 제외 입력하지 않으면 null
     * @return
     */
    @GetMapping()
    public ResponseEntity<List<BorrowRecordDto>> showBorrowRecord(
        @RequestParam(name = "onloan", required = false) Optional<Boolean> onLoan) {
        List<BorrowRecordDto> record = recordService.showBorrowRecord(onLoan);
        return ResponseEntity.ok().body(record);
    }
}
