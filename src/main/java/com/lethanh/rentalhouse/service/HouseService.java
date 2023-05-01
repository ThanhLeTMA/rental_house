package com.lethanh.rentalhouse.service;

import com.lethanh.rentalhouse.model.HouseModel;
import com.lethanh.rentalhouse.model.RoomModel;

import java.util.List;
import java.util.Optional;

public interface HouseService {
    HouseModel createHouse(HouseModel houseModel);
    List<HouseModel> findAll();

    List<HouseModel> findAllById(Long id);

    HouseModel updateHouse(HouseModel houseModel);
    void deleteHouse(Long id);

    List<HouseModel> getHouseDetails(Long id);
    HouseModel assignRoomToHouse(Long houseId, Long roomId);
    public int calculateTotalRoomPrice(Long house_id);
    public int calculateTotalRoom(Long house_id);
}
