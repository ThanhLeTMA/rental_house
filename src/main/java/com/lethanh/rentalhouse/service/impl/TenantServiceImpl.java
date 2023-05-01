package com.lethanh.rentalhouse.service.impl;

import com.lethanh.rentalhouse.model.RoomModel;
import com.lethanh.rentalhouse.model.TenantModel;
import com.lethanh.rentalhouse.repository.RoomRepository;
import com.lethanh.rentalhouse.repository.TenantRepository;
import com.lethanh.rentalhouse.service.TenantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class TenantServiceImpl implements TenantService {
    @Autowired
    TenantRepository tenantRepository;
    @Autowired
    RoomRepository roomRepository;

    public TenantServiceImpl(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    @Override
    public TenantModel createTenant(TenantModel tenantModel) {
        return tenantRepository.save(tenantModel);
    }

    @Override
    public TenantModel updateTenant(TenantModel tenantModel) {
        return tenantRepository.save(tenantModel);
    }

    @Override
    public List<TenantModel> viewAllTenants() {
        return tenantRepository.findAll();
    }

    @Override
    public Optional<TenantModel> viewTenantDetail(Long id) {
        return tenantRepository.findById(id);
    }

    @Override
    public List<TenantModel> getTenantDetails(Long id) {
        if(id != null){
            return tenantRepository.findAllById(id);
        } else {
            return tenantRepository.findAll();
        }
    }

    @Override
    public TenantModel assignRoomToTenant(Long tenant_id, Long room_id) {
        Collection<RoomModel> roomList = null;
        TenantModel tenantModel = tenantRepository.findById(tenant_id).get();
        RoomModel roomModel = roomRepository.findById(room_id).get();
        roomList = tenantModel.getRoomList();
        roomList.add(roomModel);
        tenantModel.setRoomList(roomList);
        if((Integer)roomModel.getCurrentTenants() == null){
            roomModel.setCurrentTenants(1);
        } else{
            roomModel.setCurrentTenants(roomModel.getCurrentTenants()+1);
        }
        return tenantRepository.save(tenantModel);
    }

    @Override
    public int calculateTotalFee(Long tenant_id) {
        int sum = 0;
        Collection<RoomModel> roomList = null;
        TenantModel tenantModel = tenantRepository.findById(tenant_id).get();
        roomList = tenantModel.getRoomList();
        for(RoomModel roomModel : roomList){
            sum += roomModel.getTotalPrice();
        }
        return 0;
    }

}
