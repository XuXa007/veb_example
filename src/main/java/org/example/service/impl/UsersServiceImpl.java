package org.example.service.impl;

import org.example.dtos.UsersDto;
import org.example.exception.NotFoundException;
import org.example.models.*;
import org.example.repo.UsersRepository;
import org.example.service.UsersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ModelMapper modelMapper;

    private String user = "user";

    @Override
    public List<UsersDto> getAllUsers() {
        return usersRepository.findAll().stream().map((s) -> modelMapper.map(s, UsersDto.class)).collect(Collectors.toList());
    }

    @Override
    public UsersDto registerUser(UsersDto usersDto) {
        Users b = modelMapper.map(usersDto, Users.class);
        return modelMapper.map(usersRepository.save(b), UsersDto.class);

    }

    @Override
    public void deleteUser(UUID userID) {
        Users user = usersRepository.findById(userID)
                .orElseThrow(() -> new NotFoundException("Could not find user by id: " + userID));
        usersRepository.delete(user);
    }

    @Override
    public UsersDto updateUser(UUID userID, UsersDto updateUser) {
        Users existingUser = usersRepository.findById(userID).orElseThrow(() -> new NotFoundException("Could not find" + user + " by id: " + userID));

        Role existingRole = modelMapper.map(updateUser.getRole(), Role.class);

        existingUser.setRole(existingRole);

        existingRole.setId(updateUser.getId());
        existingUser.setUserName(updateUser.getUserName());
        existingUser.setPassword(updateUser.getPassword());
        existingUser.setFirstName(updateUser.getFirstName());
        existingUser.setLastName(updateUser.getLastName());
        existingUser.setActive(updateUser.isActive());
        existingUser.setImageURL(updateUser.getImageURL());
        existingUser.setCreated(updateUser.getCreated());
        existingUser.setModified(updateUser.getModified());

        Users savedUser = usersRepository.save(existingUser);
        return modelMapper.map(savedUser, UsersDto.class);
    }

    @Override
    public List<Model> findModelsByUserName(String userName) {
        return usersRepository.findModelsByUserName(userName);

    }

}
