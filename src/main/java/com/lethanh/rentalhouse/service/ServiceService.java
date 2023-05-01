package com.lethanh.rentalhouse.service;

import com.lethanh.rentalhouse.model.ServiceModel;

import java.util.List;

public interface ServiceService {
    ServiceModel saveService(ServiceModel serviceModel);
    void deleteService(Long id);
    List<ServiceModel> getServiceDetails(Long id);
}
