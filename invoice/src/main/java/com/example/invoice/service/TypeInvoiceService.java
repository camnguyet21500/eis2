package com.example.invoice.service;

import com.example.invoice.entity.TypeInvoiceEntity;

import java.util.List;

public interface TypeInvoiceService {
    TypeInvoiceEntity createTypeInVoice(TypeInvoiceEntity typeInvoiceEntity);

    TypeInvoiceEntity updateTypeInvoice(TypeInvoiceEntity typeInvoiceEntity);

    List<TypeInvoiceEntity> getAllTypeInvoice();

    TypeInvoiceEntity getTypeInvoiceById(long typeInvoiceId);

    void deleteTypeInvoice(long Id);
}
