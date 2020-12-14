package com.spring.assignments.applicateai.services;

import com.spring.assignments.applicateai.models.entity.Supplier;
import com.spring.assignments.applicateai.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SupplierService {
    private final SupplierRepository repository;

    @Transactional
    public List<Supplier> getAll() {
        return this.repository.getAll();
    }

    @Transactional
    public Optional<Supplier> getById(final Long supplierId) {
        return this.repository.getById(supplierId);
    }

    @Transactional
    public Supplier create(final Supplier supplier) {
        return this.repository.create(supplier.getName());
    }
}
