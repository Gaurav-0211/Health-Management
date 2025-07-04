package com.pmlfl.service.impl;

import com.pmlfl.dto.UserDto;
import com.pmlfl.models.User;
import com.pmlfl.repo.UserRepo;
import com.pmlfl.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepo repository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepo repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto getUserById(long id) {
        Optional<User> byId = repository.findById(id);

        User user;
        if (byId.isPresent()) {
            user = byId.get();
        } else {
            throw new RuntimeException("User not found for given id: " + id);
        }

        UserDto map = modelMapper.map(user, UserDto.class);

        return map;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        log.info("UserServiceImpl:: createUser Method");
        User user = modelMapper.map(userDto, User.class);
        User save = repository.save(user);
        UserDto map = modelMapper.map(save, UserDto.class);
        log.info("Successfully saved the user info in database");
        return map;
    }
    @Override
    public UserDto updateUser(long id, UserDto userDto) {
        User oldUser = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No User Exist with id: " + id));

        oldUser.setName(userDto.getName());
        oldUser.setEmail(userDto.getEmail());
        oldUser.setPhone(userDto.getPhone());
        oldUser.setAddress(userDto.getAddress());
        //oldUser.setPassword(userDto.getPassword());
        User updated = repository.save(oldUser);
        log.info("user updated successfully");
        return modelMapper.map(updated, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = repository.findAll();
        log.info("All user data sent successfully");
        return users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(long id) {
        log.info("One record deleted successfully");
        repository.deleteById(id);
    }
    @Override
    public void deleteAllUser() {
        repository.deleteAll();
    }
}
