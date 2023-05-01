package com.lethanh.rentalhouse.service.impl;


import com.lethanh.rentalhouse.dto.UserDto;
import com.lethanh.rentalhouse.model.Role;
import com.lethanh.rentalhouse.model.User;
import com.lethanh.rentalhouse.repository.RoleRepository;
import com.lethanh.rentalhouse.repository.UserRepository;
import com.lethanh.rentalhouse.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveAdminUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setUsername(userDto.getUsername());

        //encrypt the password once we integrate spring security
        //user.setPassword(userDto.getPassword());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Role role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null){
            role = setRole(0);
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public void saveManagerUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setUsername(userDto.getUsername());

        //encrypt the password once we integrate spring security
        //user.setPassword(userDto.getPassword());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Role role = roleRepository.findByName("ROLE_MANAGER");
        if(role == null){
            role = setRole(1);
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> convertEntityToDto(user))
                .collect(Collectors.toList());
    }

    private UserDto convertEntityToDto(User user){
        UserDto userDto = new UserDto();
        String[] name = user.getName().split(" ");
        userDto.setFirstName(name[0]);
        userDto.setLastName(name[1]);
        userDto.setUsername(user.getUsername());
        return userDto;
    }

    private Role checkRoleExist(String roleName) {
        Role role = new Role();
        if(roleName == "admin"){
            role.setName("ROLE_ADMIN");
        } else if (roleName == "manager") {
            role.setName("ROLE_MANAGER");
        }
        return roleRepository.save(role);
    }
    private Role setRole(int numberRole){
        Role role = new Role();
        if(numberRole == 0){
            role.setName("ROLE_ADMIN");
        } else if (numberRole == 1) {
            role.setName("ROLE_MANAGER");
        }
        return roleRepository.save(role);
    }
}
