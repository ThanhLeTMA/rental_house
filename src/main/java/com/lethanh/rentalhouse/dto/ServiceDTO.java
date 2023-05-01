package com.lethanh.rentalhouse.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Collection;

@Data
public class ServiceDTO {
    private Long id;
    private String name;
    private int price;
    @JsonIgnoreProperties("services")
    private Collection<RoomDTO> rooms;
}
