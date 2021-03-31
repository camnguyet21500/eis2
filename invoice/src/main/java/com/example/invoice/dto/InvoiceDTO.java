package com.example.invoice.dto;


public class InvoiceDTO {
    private long id;
    private String date;
    private long id_user;

    private String name_service;
    private float total;
    private long type_idId;

    private long company_idId;

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

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
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

    public long getType_idId() {
        return type_idId;
    }

    public void setType_idId(long type_idId) {
        this.type_idId = type_idId;
    }

    public long getCompany_idId() {
        return company_idId;
    }

    public void setCompany_idId(long company_idId) {
        this.company_idId = company_idId;
    }
}
