package com.example.invoice.service;

import com.example.invoice.entity.InvoiceEntity;
import com.example.invoice.exception.ResourceNotFoundException;
import com.example.invoice.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService{
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public InvoiceEntity createInVoice(InvoiceEntity invoiceEntity) {
        return invoiceRepository.save(invoiceEntity);
    }

    @Override
    public InvoiceEntity updateInvoice(InvoiceEntity invoiceEntity) {
        Optional<InvoiceEntity> invoiceEntityOptional = this.invoiceRepository.findById(invoiceEntity.getId());

        if(invoiceEntityOptional.isPresent()) {
            InvoiceEntity invoiceEntityUpdate = invoiceEntityOptional.get();

            invoiceEntityUpdate.setDate(invoiceEntity.getDate());
            invoiceEntityUpdate.setId_user(invoiceEntity.getId_user());
            invoiceEntityUpdate.setName_service(invoiceEntity.getName_service());
            invoiceEntityUpdate.setTotal(invoiceEntity.getTotal());
            invoiceEntityUpdate.setCompany_id(invoiceEntity.getCompany_id());
            invoiceEntityUpdate.setType_id(invoiceEntity.getType_id());

            invoiceRepository.save(invoiceEntityUpdate);

            return invoiceEntityUpdate;
        }else {
            throw new ResourceNotFoundException("Record not found with id: " + invoiceEntity.getId());
        }
    }

    @Override
    public List<InvoiceEntity> getAllInvoice() {
        return this.invoiceRepository.findAll();
    }

    @Override
    public InvoiceEntity getInvoiceById(long invoiceId) {
        Optional<InvoiceEntity> invoiceEntityOptional = this.invoiceRepository.findById(invoiceId);

        if(invoiceEntityOptional.isPresent()) {
            return invoiceEntityOptional.get();
        }else {
            throw new ResourceNotFoundException("Record not found with id: " + invoiceId);
        }
    }

    @Override
    public void deleteInvoice(long Id) {
        Optional<InvoiceEntity> invoiceEntityOptional = this.invoiceRepository.findById(Id);

        if(invoiceEntityOptional.isPresent()) {
            this.invoiceRepository.delete(invoiceEntityOptional.get());
        }else {
            throw new ResourceNotFoundException("Record not found with id: " + Id);
        }
    }
}
