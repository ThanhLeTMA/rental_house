package com.lethanh.rentalhouse.repository;

import com.lethanh.rentalhouse.model.InvoiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceModel, Long> {
    List<InvoiceModel> findAllById(Long id);
    void deleteById(Long id);
}
