package com.example.invoice.service;

import com.example.invoice.entity.CompanyEntity;
import com.example.invoice.entity.InvoiceEntity;
import com.example.invoice.exception.ResourceNotFoundException;
import com.example.invoice.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService{
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public CompanyEntity createCompany(CompanyEntity companyEntity) {
        return companyRepository.save(companyEntity);
    }

    @Override
    public CompanyEntity updateCompany(CompanyEntity companyEntity) {
        Optional<CompanyEntity> companyEntityOptional = this.companyRepository.findById(companyEntity.getId());

        if(companyEntityOptional.isPresent()) {
            CompanyEntity companyEntityUpdate = companyEntityOptional.get();
            companyEntityUpdate.setName(companyEntity.getName());
            companyEntityUpdate.setAddress(companyEntity.getAddress());

            companyRepository.save(companyEntityUpdate);
            return companyEntityUpdate;
        }else {
            throw new ResourceNotFoundException("Record not found with id: " + companyEntity.getId());
        }
    }

    @Override
    public List<CompanyEntity> getAllCompany() {
        return this.companyRepository.findAll();
    }

    @Override
    public CompanyEntity getCompanyById(long companyId) {
        Optional<CompanyEntity> companyEntityOptional = this.companyRepository.findById(companyId);

        if(companyEntityOptional.isPresent()) {
            return companyEntityOptional.get();
        }else {
            throw new ResourceNotFoundException("Record not found with id: " + companyId);
        }
    }

    @Override
    public void deleteCompany(long Id) {
        Optional<CompanyEntity> companyEntityOptional = this.companyRepository.findById(Id);

        if(companyEntityOptional.isPresent()) {
            this.companyRepository.delete(companyEntityOptional.get());
        }else {
            throw new ResourceNotFoundException("Record not found with id: " + Id);
        }
    }
}
