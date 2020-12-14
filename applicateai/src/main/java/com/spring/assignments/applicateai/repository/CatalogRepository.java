package com.spring.assignments.applicateai.repository;

import com.spring.assignments.applicateai.models.entity.Catalog;

import java.util.List;
import java.util.Optional;

public interface CatalogRepository {
    /**
     * Creates Catalog
     * @param catalog
     * @return catalog
     */
    Catalog create(Catalog catalog);

    /**
     * Gets product by id from Catalogs
     * @param id
     * @return catalog
     */
    Optional<Catalog> getById(Long id);

    /**
     * Gets all catalogs
     * @return catalogList
     */
    List<Catalog> getAll();

    /**
     * Searches catalog by skuName
     * @param skuName
     * @return
     */
    List<Catalog> filterByName(String skuName);
}