package com.lethanh.rentalhouse.service;

import com.lethanh.rentalhouse.dto.UserDto;
import com.lethanh.rentalhouse.model.User;

import java.util.List;

public interface UserService {
    void saveAdminUser(UserDto userDto);
    void saveManagerUser(UserDto userDto);

    User findByUsername(String username);

    List<UserDto> findAllUsers();
}
