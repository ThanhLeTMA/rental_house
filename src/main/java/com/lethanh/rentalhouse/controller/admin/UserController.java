package com.lethanh.rentalhouse.controller.admin;

import com.lethanh.rentalhouse.dto.UserDto;
import com.lethanh.rentalhouse.model.User;
import com.lethanh.rentalhouse.service.UserService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/all")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/userManager")
    public ResponseEntity<User> createUserManager(@RequestBody UserDto userDto){
        userService.saveManagerUser(userDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping("/userAdmin")
    public ResponseEntity<User> createUserAdmin(@RequestBody UserDto userDto){
        userService.saveAdminUser(userDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
