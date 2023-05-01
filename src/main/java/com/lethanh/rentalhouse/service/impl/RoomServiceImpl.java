package com.lethanh.rentalhouse.service.impl;

import com.lethanh.rentalhouse.model.RoomModel;
import com.lethanh.rentalhouse.model.ServiceModel;
import com.lethanh.rentalhouse.repository.RoomRepository;
import com.lethanh.rentalhouse.repository.ServiceRepository;
import com.lethanh.rentalhouse.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    ServiceRepository serviceRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public RoomModel saveRoom(RoomModel roomModel) {
        roomModel.setTotalPrice(roomModel.getRents());
        return roomRepository.save(roomModel);
    }

    @Override
    public List<RoomModel> getRoomDetails(Long roomId) {
        if(roomId != null){
            return roomRepository.findAllById(roomId);
        } else {
            return roomRepository.findAll();
        }
    }

    @Override
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

    @Override
    public RoomModel assignServiceToRoom(Long roomId, Long serviceId) {
        Collection<ServiceModel> serviceList = null;
        RoomModel roomModel = roomRepository.findById(roomId).get();
        ServiceModel serviceModel = serviceRepository.findById(serviceId).get();
        serviceList = roomModel.getServices();
        serviceList.add(serviceModel);
        roomModel.setServices(serviceList);
        roomModel.setTotalPrice(this.calculateTotalPrice(roomId)+roomModel.getRents());
        return roomRepository.save(roomModel);
    }

    @Override
    public int calculateTotalPrice(Long roomId) {
        int sum = 0;
        Collection<ServiceModel> serviceList = null;
        RoomModel roomModel = roomRepository.findById(roomId).get();
        serviceList = roomModel.getServices();
        for(ServiceModel serviceModel : serviceList){
            sum += serviceModel.getPrice();
        }
        return sum;
    }
}
