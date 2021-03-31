package com.example.invoice.repository;

import com.example.invoice.entity.TypeInvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeInvoiceRepository extends JpaRepository<TypeInvoiceEntity, Long> {
}
