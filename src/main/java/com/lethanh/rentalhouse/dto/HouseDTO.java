package com.lethanh.rentalhouse.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lethanh.rentalhouse.model.RoomModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Set;

@Data
public class HouseDTO {
    private Long id;
    private String name;
    private String location;
    private String street;
    private int totalRoom;
    private int totalRoomPrice;
    @JsonIgnoreProperties("houseDTO")
    private Collection<RoomDTO> roomDTOS;
}
