package com.bevis.fileservice.controllers;

import com.bevis.fileservice.services.excel.IExcelService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/excel")
public class ExcelController {

    IExcelService _excelService;

    @GetMapping("/export")
    public ResponseEntity<?> getStatus() {
        return _excelService.exportDataTest();
    }
}
