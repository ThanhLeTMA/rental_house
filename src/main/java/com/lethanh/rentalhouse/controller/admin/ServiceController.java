package com.lethanh.rentalhouse.controller.admin;

import com.lethanh.rentalhouse.dto.ServiceDTO;
import com.lethanh.rentalhouse.model.ServiceModel;
import com.lethanh.rentalhouse.service.ServiceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin/service")
public class ServiceController {
    @Autowired
    ServiceService serviceService;
    @Autowired
    ModelMapper modelMapper;
    @GetMapping(value = {"/getServices", "{serviceId}"})
    public List<ServiceDTO> getServiceDetails(@PathVariable(required = false) Long serviceId){
        return serviceService.getServiceDetails(serviceId).stream().map(serviceModel -> modelMapper.map(serviceModel, ServiceDTO.class)).collect(Collectors.toList());
    }
    @DeleteMapping("/delete/{serviceId}")
    public ResponseEntity removeService(@PathVariable Long serviceId){
        serviceService.deleteService(serviceId);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity createService(@RequestBody ServiceModel serviceModel){
        serviceService.saveService(serviceModel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
