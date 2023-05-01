package com.lethanh.rentalhouse.controller.admin;

import com.lethanh.rentalhouse.dto.HouseDTO;
import com.lethanh.rentalhouse.model.HouseModel;
import com.lethanh.rentalhouse.service.HouseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin/house")
public class HouseController {
    @Autowired
    HouseService houseService;
    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/houses")
    public List<HouseDTO> viewAllHouse() {
        return houseService.findAll().stream().map(HouseModel -> modelMapper.map(HouseModel, HouseDTO.class)).collect(Collectors.toList());
    }

    //    @GetMapping(value = {"/{id}", "/getHouses"})
//    public List<HouseDTO> getHouseDetail(@PathVariable(required = false) Long id){
//        return houseService.findAllById(id).stream().map(houseModel -> modelMapper.map(houseModel, HouseDTO.class)).collect(Collectors.toList());
//    }
    @GetMapping(value = {"/{id}", "/getHouses"})
    public List<HouseModel> getHouseDetail(@PathVariable(required = false) Long id) {
        return houseService.findAllById(id);
//        return houseService.findAllById(id).stream().map(houseModel -> modelMapper.map(houseModel, HouseDTO.class)).collect(Collectors.toList());
    }

    @PostMapping("/save")
    public ResponseEntity createHouse(@RequestBody HouseModel houseModel) {
        houseService.createHouse(houseModel);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public HouseModel updateHouse(@RequestBody HouseModel houseModel) {
        return houseService.updateHouse(houseModel);
    }

    @DeleteMapping("/delete/{id}")
    public void removeHouse(@PathVariable Long id) {
        houseService.deleteHouse(id);
    }

    @PutMapping("/{house_id}/room/{room_id}")
    public HouseModel assignRoomToHouse(@PathVariable Long house_id, @PathVariable Long room_id) {
        return houseService.assignRoomToHouse(house_id, room_id);
    }

}
