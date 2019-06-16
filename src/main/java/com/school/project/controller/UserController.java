package com.school.project.controller;

import com.school.project.dto.UserDto;
import com.school.project.model.entities.User;
import com.school.project.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserService userService;

    @PostMapping("/users")
    public void createUser(@RequestBody UserDto userDto) {
        User user = convertUserDtoToUser(userDto);
        userService.create(user);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getUserByID(@PathVariable long id) {
        return ResponseEntity.ok()
                .body(convertUserToUserDto(userService.getUserById(id)));
    }

    @GetMapping("/users")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers()
                .stream()
                .map(s -> convertUserToUserDto(s))
                .collect(Collectors.toList());
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto useDto, @PathVariable Long id) {
        userService.update(convertUserDtoToUser(useDto), id);
        return ResponseEntity.ok()
                .body(convertUserToUserDto(userService.getUserById(id)));
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }

    private User convertUserDtoToUser(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    private UserDto convertUserToUserDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

}
