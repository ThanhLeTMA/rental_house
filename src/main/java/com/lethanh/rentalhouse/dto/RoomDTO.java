package com.lethanh.rentalhouse.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Collection;

@Data
public class RoomDTO {
    private Long id;
    private Long house_id;
    private int currentTenants;
    private int rents;
    private int totalPrice;
    @JsonIgnoreProperties("rooms")
    private Collection<ServiceDTO> services;
    @JsonIgnoreProperties("roomDTOS")
    private HouseDTO houseDTO;
    @JsonIgnoreProperties("roomList")
    private Collection<TenantDTO> tenants;

}
