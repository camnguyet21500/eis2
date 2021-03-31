package com.example.invoice.controller;

import com.example.invoice.entity.CompanyEntity;
import com.example.invoice.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/companies", method = RequestMethod.GET)
    public ResponseEntity<List<CompanyEntity>> getAllCompany(){
        return ResponseEntity.ok().body(companyService.getAllCompany());
    }

    @RequestMapping(value = "/companies/{id}", method = RequestMethod.GET)
    public ResponseEntity<CompanyEntity> getCompanyById(@PathVariable long id){
        return ResponseEntity.ok().body(companyService.getCompanyById(id));
    }

    @RequestMapping(value = "/companies", method = RequestMethod.POST)
    public ResponseEntity<CompanyEntity> createCompany(@RequestBody CompanyEntity companyEntity){
        return ResponseEntity.ok().body(this.companyService.createCompany(companyEntity));
    }

    @RequestMapping(value = "/companies/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CompanyEntity> updateCompany(@PathVariable long id, @RequestBody CompanyEntity companyEntity){
        companyEntity.setId(id);
        return ResponseEntity.ok().body(this.companyService.updateCompany(companyEntity));
    }

    @RequestMapping(value = "/companies/{id}", method = RequestMethod.DELETE)
    public HttpStatus deleteCompany(@PathVariable long id){
        this.companyService.deleteCompany(id);
        return HttpStatus.OK;
    }
}
