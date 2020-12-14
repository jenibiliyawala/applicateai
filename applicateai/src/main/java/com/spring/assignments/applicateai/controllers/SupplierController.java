package com.spring.assignments.applicateai.controllers;

import com.spring.assignments.applicateai.models.entity.Supplier;
import com.spring.assignments.applicateai.services.SupplierService;
import com.spring.assignments.applicateai.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/suppliers")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SupplierController{
    private final SupplierService service;

    @GetMapping
    public ResponseEntity<List<Supplier>> getAll() {
        final List<Supplier> response = this.service.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Supplier> create(@Valid @RequestBody final Supplier supplier) {
        final Supplier response = this.service.create(supplier);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getById(@PathVariable("id") Long supplierId) throws NotFoundException {
        final Supplier response = this.service
                        .getById(supplierId)
                        .orElseThrow(() -> new NotFoundException("supplierId " + supplierId + " not found"));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}