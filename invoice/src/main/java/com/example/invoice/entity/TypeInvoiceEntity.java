package com.example.invoice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "type_invoice")

public class TypeInvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "code", length = 45)
    private String code;

    @NotNull
    @Column(name = "name_invoice", length = 45)
    private String name_invoice;

    @NotNull
    @Column(name = "vat")
    private float vat;

    @JsonIgnore
    @OneToMany(mappedBy = "type_id")
    private List<InvoiceEntity> invoices ;

    public TypeInvoiceEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName_invoice() {
        return name_invoice;
    }

    public void setName_invoice(String name_invoice) {
        this.name_invoice = name_invoice;
    }

    public float getVat() {
        return vat;
    }

    public void setVat(float vat) {
        this.vat = vat;
    }

    public List<InvoiceEntity> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<InvoiceEntity> invoices) {
        this.invoices = invoices;
    }
}
