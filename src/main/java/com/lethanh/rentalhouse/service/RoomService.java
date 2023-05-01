package com.lethanh.rentalhouse.service;

import com.lethanh.rentalhouse.model.RoomModel;

import java.util.List;

public interface RoomService {
    RoomModel saveRoom(RoomModel roomModel);
    List<RoomModel> getRoomDetails(Long id);
    void deleteRoom(Long id);
    RoomModel assignServiceToRoom(Long roomId, Long serviceId);

    int calculateTotalPrice(Long roomId);
}
