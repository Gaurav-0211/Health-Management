package com.pmlfl.service.impl;

import com.pmlfl.dto.UserDto;
import com.pmlfl.models.User;
import com.pmlfl.repo.UserRepo;
import com.pmlfl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepo repository;

    public UserServiceImpl(UserRepo repository) {
        this.repository = repository;
    }

    @Override
    public Optional<User> getUserById(long id) {
        return repository.findById(id);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setPhone(userDto.getPhone());
        user.setAddress(userDto.getAddress());
        user.setPassword(userDto.getPassword());

        User save = repository.save(user);

        userDto.setId(save.getId());
        userDto.setName(save.getName());
        userDto.setEmail(save.getEmail());
        userDto.setPhone(save.getPhone());
        userDto.setAddress(save.getAddress());
        userDto.setPassword(save.getPassword());

        return userDto;
    }


}
