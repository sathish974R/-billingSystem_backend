package com.example.billing.service;

import com.example.billing.entity.Invoice;
import com.example.billing.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    public Map<String, Object> getSalesReport() {
        List<Invoice> invoices = invoiceRepository.findAll();
        BigDecimal totalSales = invoices.stream()
                .map(Invoice::getTotalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        int totalInvoices = invoices.size();

        Map<String, Object> report = new HashMap<>();
        report.put("totalSales", totalSales);
        report.put("totalInvoices", totalInvoices);
        return report;
    }
}
