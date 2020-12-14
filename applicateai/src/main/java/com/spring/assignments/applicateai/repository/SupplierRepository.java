package com.spring.assignments.applicateai.repository;

import com.spring.assignments.applicateai.models.entity.Supplier;

import java.util.List;
import java.util.Optional;

public interface SupplierRepository {
    /**
     * Creates supplier
     * @param name
     * @return supplier
     */
    Supplier create(String name);

    /**
     * Gets supplier by id
     * @param id
     * @return catalog
     */
    Optional<Supplier> getById(Long id);


    /**
     * Gets supplier by name
     * @param name
     * @return catalog
     */
    Optional<Supplier> getByName(String name);

    /**
     * Gets all suppliers
     * @return supplierList
     */
    List<Supplier> getAll();
}
