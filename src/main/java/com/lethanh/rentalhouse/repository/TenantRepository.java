package com.lethanh.rentalhouse.repository;

import com.lethanh.rentalhouse.model.TenantModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TenantRepository extends JpaRepository<TenantModel, Long> {
    List<TenantModel> findAllById(Long id);
}
