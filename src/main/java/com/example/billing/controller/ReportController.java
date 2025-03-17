package com.example.billing.controller;

import com.example.billing.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin("*")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/sales")
    public ResponseEntity<Map<String, Object>> getSalesReport() {
        return ResponseEntity.ok(reportService.getSalesReport());
    }
}
