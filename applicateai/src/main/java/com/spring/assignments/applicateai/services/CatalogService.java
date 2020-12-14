package com.spring.assignments.applicateai.services;

import com.spring.assignments.applicateai.models.dto.CatalogDto;
import com.spring.assignments.applicateai.models.dto.mappers.CatalogMapper;
import com.spring.assignments.applicateai.models.entity.Catalog;
import com.spring.assignments.applicateai.models.entity.Supplier;
import com.google.common.collect.Lists;
import com.spring.assignments.applicateai.repository.CatalogRepository;
import com.spring.assignments.applicateai.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CatalogService {
    private final CatalogRepository repository;
    private final SupplierRepository supplierRepository;

    @Transactional
    public List<Catalog> getAll() {
        return this.repository.getAll();
    }

    @Transactional
    public Optional<Catalog> getById(final Long catalogId) {
        return this.repository.getById(catalogId);
    }

    @Transactional
    public Catalog create(final CatalogDto catalogDto) {
        Optional<Supplier> optionalSupplier = supplierRepository.getByName(catalogDto.getSupplierName());
        if(!optionalSupplier.isPresent())
            throw new RuntimeException("Invalid Supplier Name: " + catalogDto.getSupplierName());
        Catalog catalog = CatalogMapper.toCatalog(catalogDto);
        catalog.setSupplier(optionalSupplier.get());
        return this.repository.create(catalog);
    }

    @Transactional
    public Map<String, List<Catalog>> filterBySkuName(final String skuName) {
        Map<String, List<Catalog>> catalogMap = new HashMap<>();
        List<Catalog> catalogs = this.repository.filterByName(skuName);
        catalogs.forEach(c -> {
            String supplier = c.getSupplier().getName();
            if(catalogMap.containsKey(supplier))
                catalogMap.get(supplier).add(c);
            else
                catalogMap.put(supplier, Lists.newArrayList(c));
        });
        return catalogMap;
    }
}