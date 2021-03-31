package com.example.invoice.service;

import com.example.invoice.entity.CompanyEntity;

import java.util.List;

public interface CompanyService {
    CompanyEntity createCompany(CompanyEntity companyEntity);

    CompanyEntity updateCompany(CompanyEntity companyEntity);

    List<CompanyEntity> getAllCompany();

    CompanyEntity getCompanyById(long companyId);

    void deleteCompany(long Id);
}
