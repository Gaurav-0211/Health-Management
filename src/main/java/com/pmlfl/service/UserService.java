package com.pmlfl.service;


import com.pmlfl.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserDto getUserById(long id);

    UserDto createUser(UserDto userDto);


    UserDto updateUser(long id, UserDto userDto);

    List<UserDto> getAllUser();

    void deleteUser(long id);

    void deleteAllUser();





}
