package com.lethanh.rentalhouse.repository;

import com.lethanh.rentalhouse.model.ServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceModel, Long> {
    List<ServiceModel> findAllById(Long id);
}
