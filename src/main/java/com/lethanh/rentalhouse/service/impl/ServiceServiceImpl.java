package com.lethanh.rentalhouse.service.impl;

import com.lethanh.rentalhouse.model.ServiceModel;
import com.lethanh.rentalhouse.repository.ServiceRepository;
import com.lethanh.rentalhouse.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    ServiceRepository serviceRepository;

    public ServiceServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public ServiceModel saveService(ServiceModel serviceModel) {
        return serviceRepository.save(serviceModel);
    }

    @Override
    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public List<ServiceModel> getServiceDetails(Long serviceId) {
        if(serviceId != null){
            return serviceRepository.findAllById(serviceId);
        } else {
            return serviceRepository.findAll();
        }
    }

}
