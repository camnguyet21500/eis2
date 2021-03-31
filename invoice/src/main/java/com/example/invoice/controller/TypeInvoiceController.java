package com.example.invoice.controller;

import com.example.invoice.entity.TypeInvoiceEntity;
import com.example.invoice.service.TypeInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TypeInvoiceController {
    @Autowired
    private TypeInvoiceService typeInvoiceService;

    @RequestMapping(value = "/typeInvoices", method = RequestMethod.GET)
    public ResponseEntity<List<TypeInvoiceEntity>> getAllTypeInvoice(){
        return ResponseEntity.ok().body(typeInvoiceService.getAllTypeInvoice());
    }

    @RequestMapping(value = "/typeInvoices/{id}", method = RequestMethod.GET)
    public ResponseEntity<TypeInvoiceEntity> getTypeInvoiceById(@PathVariable long id){
        return ResponseEntity.ok().body(typeInvoiceService.getTypeInvoiceById(id));
    }

    @RequestMapping(value = "/typeInvoices", method = RequestMethod.POST)
    public ResponseEntity<TypeInvoiceEntity> createTypeInvoice(@RequestBody TypeInvoiceEntity typeInvoiceEntity){
        return ResponseEntity.ok().body(this.typeInvoiceService.createTypeInVoice(typeInvoiceEntity));
    }

    @RequestMapping(value = "/typeInvoices/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TypeInvoiceEntity> updateTypeInvoice(@PathVariable long id, @RequestBody TypeInvoiceEntity typeInvoiceEntity){
        typeInvoiceEntity.setId(id);
        return ResponseEntity.ok().body(this.typeInvoiceService.updateTypeInvoice(typeInvoiceEntity));
    }

    @RequestMapping(value = "/typeInvoices/{id}", method = RequestMethod.DELETE)
    public HttpStatus deleteTypeInvoice(@PathVariable long id){
        this.typeInvoiceService.deleteTypeInvoice(id);
        return HttpStatus.OK;
    }
}
