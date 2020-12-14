package com.spring.assignments.applicateai.repository.jpa;

import com.spring.assignments.applicateai.models.entity.Supplier;
import com.spring.assignments.applicateai.repository.SupplierRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpringJpaSupplierRepository extends JpaRepository<Supplier, Long>, SupplierRepository {
    default Supplier create(String name) {
        final Supplier supplier = Supplier.builder().name(name).build();
        return this.save(supplier);
    }

    default Optional<Supplier> getById(Long id){
        return this.findById(id);
    }

    @Query("select s from Supplier s where s.name = :name")
    Optional<Supplier> getByName(String name);

    default List<Supplier> getAll() {
        return this.findAll();
    }
}
