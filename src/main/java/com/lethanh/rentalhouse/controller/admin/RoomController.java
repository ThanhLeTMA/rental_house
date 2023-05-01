package com.lethanh.rentalhouse.controller.admin;

import com.lethanh.rentalhouse.dto.RoomDTO;
import com.lethanh.rentalhouse.model.RoomModel;
import com.lethanh.rentalhouse.service.RoomService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin/room")
public class RoomController {
    @Autowired
    RoomService roomService;
    @Autowired
    ModelMapper modelMapper;
    @GetMapping(value = {"/getRooms", "/{roomId}"})
    public List<RoomDTO> getRoomDetails(@PathVariable(required = false) Long roomId){
        return roomService.getRoomDetails(roomId).stream().map(roomModel -> modelMapper.map(roomModel, RoomDTO.class)).collect(Collectors.toList());
    }
    @DeleteMapping("/delete/{roomId}")
    public ResponseEntity removeRoom(@PathVariable Long roomId){
        roomService.deleteRoom(roomId);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<RoomModel> createRoom(@RequestBody RoomModel roomModel){
        roomService.saveRoom(roomModel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/{roomId}/service/{serviceId}")
    public RoomDTO assignServiceToRoom(@PathVariable Long roomId, @PathVariable Long serviceId){
//        return roomService.assignServiceToRoom(roomId, serviceId);
        return modelMapper.map(roomService.assignServiceToRoom(roomId, serviceId), RoomDTO.class);
    }
}
