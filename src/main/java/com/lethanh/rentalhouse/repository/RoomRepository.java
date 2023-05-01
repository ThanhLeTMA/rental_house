package com.lethanh.rentalhouse.repository;

import com.lethanh.rentalhouse.model.RoomModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<RoomModel, Long> {
    List<RoomModel> findAllById(Long id);

    @Override
    Optional<RoomModel> findById(Long aLong);
}
