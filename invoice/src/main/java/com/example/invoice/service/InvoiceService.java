package com.example.invoice.service;

import com.example.invoice.entity.InvoiceEntity;

import java.util.List;

public interface InvoiceService {
    InvoiceEntity createInVoice(InvoiceEntity invoiceEntity);

    InvoiceEntity updateInvoice(InvoiceEntity invoiceEntity);

    List<InvoiceEntity> getAllInvoice();

    InvoiceEntity getInvoiceById(long invoiceId);

    void deleteInvoice(long Id);
}
