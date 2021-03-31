package com.example.invoice.service;

import com.example.invoice.entity.TypeInvoiceEntity;
import com.example.invoice.exception.ResourceNotFoundException;
import com.example.invoice.repository.TypeInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TypeInvoiceServiceImp implements TypeInvoiceService{

    @Autowired
    private TypeInvoiceRepository typeInvoiceRepository;

    @Override
    public TypeInvoiceEntity createTypeInVoice(TypeInvoiceEntity typeInvoiceEntity) {
        return typeInvoiceRepository.save(typeInvoiceEntity);
    }

    @Override
    public TypeInvoiceEntity updateTypeInvoice(TypeInvoiceEntity typeInvoiceEntity) {
        Optional<TypeInvoiceEntity> typeInvoiceEntityOptional = this.typeInvoiceRepository.findById(typeInvoiceEntity.getId());

        if(typeInvoiceEntityOptional.isPresent()) {

            TypeInvoiceEntity typeInvoiceEntityUpdate = typeInvoiceEntityOptional.get();

            typeInvoiceEntityUpdate.setCode(typeInvoiceEntity.getCode());
            typeInvoiceEntityUpdate.setName_invoice(typeInvoiceEntity.getName_invoice());
            typeInvoiceEntityUpdate.setVat(typeInvoiceEntity.getVat());

            typeInvoiceRepository.save(typeInvoiceEntityUpdate);

            return typeInvoiceEntityUpdate;

        }else {
            throw new ResourceNotFoundException("Record not found with id: " + typeInvoiceEntity.getId());
        }
    }

    @Override
    public List<TypeInvoiceEntity> getAllTypeInvoice() {

        return this.typeInvoiceRepository.findAll();
    }

    @Override
    public TypeInvoiceEntity getTypeInvoiceById(long typeInvoiceId) {
        Optional<TypeInvoiceEntity> typeInvoiceEntityOptional = this.typeInvoiceRepository.findById(typeInvoiceId);

        if(typeInvoiceEntityOptional.isPresent()) {
            return typeInvoiceEntityOptional.get();
        }else {
            throw new ResourceNotFoundException("Record not found with id: " + typeInvoiceId);
        }
    }

    @Override
    public void deleteTypeInvoice(long typeInvoiceId) {
        Optional<TypeInvoiceEntity> typeInvoiceEntityOptionaly = this.typeInvoiceRepository.findById(typeInvoiceId);

        if(typeInvoiceEntityOptionaly.isPresent()) {
            this.typeInvoiceRepository.delete(typeInvoiceEntityOptionaly.get());
        }else {
            throw new ResourceNotFoundException("Record not found with id: " + typeInvoiceId);
        }
    }
}
