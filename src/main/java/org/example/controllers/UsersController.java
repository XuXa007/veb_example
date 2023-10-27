package org.example.controllers;

import org.example.dtos.UsersDto;
import org.example.models.Model;
import org.example.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    Iterable<UsersDto> all() {
        return usersService.getAllUsers();
    }

    @PostMapping("/user")
    UsersDto newUser(@RequestBody UsersDto newUser) {
        return usersService.registerUser(newUser);
    }

    @DeleteMapping("/user/{userID}")
    void deleteUser(@PathVariable("userID") UsersDto usersDto) {
        usersService.registerUser(usersDto);
    }

    @PutMapping("/user/{userID}")
    public UsersDto updateUser(@PathVariable("userID") UUID userID, @RequestBody UsersDto updateUser) {
        return usersService.updateUser(userID, updateUser);
    }

    @GetMapping("/modelFindByUserName/{userName}")
    public List<Model> findModelsByUserName(@PathVariable("userName") String userName) {
        return usersService.findModelsByUserName(userName);
    }
}
