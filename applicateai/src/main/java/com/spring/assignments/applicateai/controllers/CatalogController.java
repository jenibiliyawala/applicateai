package com.spring.assignments.applicateai.controllers;

import com.spring.assignments.applicateai.exceptions.NotFoundException;
import com.spring.assignments.applicateai.models.dto.CatalogDto;
import com.spring.assignments.applicateai.models.entity.Catalog;
import com.spring.assignments.applicateai.services.CatalogService;
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
import java.util.Map;

@RestController
@RequestMapping(path="/api/v1/catalogs")
@RequiredArgsConstructor(onConstructor=@__(@Autowired))
public class CatalogController {
    private final CatalogService service;

    @GetMapping
    public ResponseEntity<List<Catalog>> getAll() {
        final List<Catalog> response = this.service.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Catalog> create(@Valid @RequestBody final CatalogDto catalogDto) {
        final Catalog response = this.service.create(catalogDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Catalog> getById(@PathVariable("id") Long catalogId) throws NotFoundException {
        final Catalog response = this.service
                        .getById(catalogId)
                        .orElseThrow(() -> new NotFoundException("catalogId " + catalogId + " not found"));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/name/{skuName}")
    public ResponseEntity<Map<String, List<Catalog>>> filterBySkuName(@PathVariable("skuName") String skuName) {
        final Map<String, List<Catalog>> response = this.service.filterBySkuName(skuName);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}