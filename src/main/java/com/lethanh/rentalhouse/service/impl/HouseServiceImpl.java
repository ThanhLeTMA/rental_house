package com.lethanh.rentalhouse.service.impl;

import com.lethanh.rentalhouse.model.HouseModel;
import com.lethanh.rentalhouse.model.RoomModel;
import com.lethanh.rentalhouse.model.ServiceModel;
import com.lethanh.rentalhouse.repository.HouseRepository;
import com.lethanh.rentalhouse.repository.RoomRepository;
import com.lethanh.rentalhouse.repository.ServiceRepository;
import com.lethanh.rentalhouse.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    HouseRepository houseRepository;
    @Autowired
    RoomRepository roomRepository;


    public HouseServiceImpl(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }


    @Override
    public HouseModel createHouse(HouseModel houseModel) {
        return houseRepository.save(houseModel);
    }

    public List<HouseModel> findAll(){
        return houseRepository.findAll();
    }
    @Override
    public List<HouseModel> findAllById(Long id) {
        if(id != null){
            return houseRepository.findAllById(id);
        } else {
            return houseRepository.findAll();
        }
    }


    @Override
    public HouseModel updateHouse(HouseModel houseModel) {
        return houseRepository.save(houseModel);
    }

    @Override
    public void deleteHouse(Long id) {
        houseRepository.deleteById(id);
    }

    @Override
    public List<HouseModel> getHouseDetails(Long id) {
        if(id!=null){
            List<HouseModel> houseModelList = houseRepository.findAllById(id);
            for(HouseModel houseModel : houseModelList){
                houseModel.setTotalRoomPrice(this.calculateTotalRoomPrice(houseModel.getId()));
            }
            return houseModelList;
        } else {
            List<HouseModel> houseModelList = houseRepository.findAll();
            for(HouseModel houseModel : houseModelList){
                houseModel.setTotalRoomPrice(this.calculateTotalRoomPrice(houseModel.getId()));
            }
            return houseModelList;
        }
    }

    @Override
    public HouseModel assignRoomToHouse(Long houseId, Long roomId) {
        Collection<RoomModel> roomList = null;
        HouseModel houseModel = houseRepository.findById(houseId).get();
        RoomModel roomModel = roomRepository.findAllById(roomId).get(0);
        roomList = houseModel.getRooms();
        roomList.add(roomModel);
        houseModel.setRooms(roomList);
        for(RoomModel roomModel1 : roomList){
            roomModel1.setHouse(houseModel);
        }
        houseModel.setTotalRoomPrice(this.calculateTotalRoomPrice(houseId));
        houseModel.setTotalRoom(this.calculateTotalRoom(houseId));
        return houseRepository.save(houseModel);
    }
    @Override
    public int calculateTotalRoomPrice(Long house_id){
        int sum = 0;
        Collection<RoomModel> roomList = null;
        HouseModel houseModel = houseRepository.findById(house_id).get();
        roomList = houseModel.getRooms();
        for(RoomModel roomModel : roomList){
            sum += roomModel.getTotalPrice();
        }
        return sum;
    }

    @Override
    public int calculateTotalRoom(Long house_id) {
        HouseModel houseModel = houseRepository.findById(house_id).get();
        return houseModel.getRooms().size();
    }


}
