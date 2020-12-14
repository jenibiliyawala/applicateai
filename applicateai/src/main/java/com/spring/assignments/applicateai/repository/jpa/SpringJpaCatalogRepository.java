package com.spring.assignments.applicateai.repository.jpa;

import com.spring.assignments.applicateai.models.entity.Catalog;
import com.spring.assignments.applicateai.repository.CatalogRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpringJpaCatalogRepository extends JpaRepository<Catalog, Long>, CatalogRepository {
    default Catalog create(Catalog catalog) {
        return this.save(catalog);
    }

    default Optional<Catalog> getById(Long id){
        return this.findById(id);
    }

    @Query("select c from Catalog c where c.skuName like concat('%', :skuName, '%')")
    List<Catalog> filterByName(String skuName);

    default List<Catalog> getAll() {
        return this.findAll();
    }
}
