package com.lethanh.rentalhouse.repository;

import com.lethanh.rentalhouse.model.HouseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HouseRepository extends JpaRepository<HouseModel, Long> {
    List<HouseModel> findAllById(Long house_id);
    HouseModel save(HouseModel houseModel);


    Optional<HouseModel> findById(Long id);
}
