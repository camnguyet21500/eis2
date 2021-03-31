package com.example.invoice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "invoice")
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "date")
    private String date;

    @NotNull
    @Column(name = "id_user")
    private int id_user;

    @NotNull
    @Column(name = "name_service", length = 45)
    private String name_service;

    @NotNull
    @Column(name = "total")
    private float total;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private TypeInvoiceEntity type_id;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private CompanyEntity company_id;

    public InvoiceEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName_service() {
        return name_service;
    }

    public void setName_service(String name_service) {
        this.name_service = name_service;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public TypeInvoiceEntity getType_id() {
        return type_id;
    }

    public void setType_id(TypeInvoiceEntity type_id) {
        this.type_id = type_id;
    }

    public CompanyEntity getCompany_id() {
        return company_id;
    }

    public void setCompany_id(CompanyEntity company_id) {
        this.company_id = company_id;
    }
}
