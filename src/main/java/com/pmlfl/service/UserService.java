package com.pmlfl.service;


import com.pmlfl.dto.UserDto;
import com.pmlfl.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserService {
    UserDto getUserById(long id);

    UserDto createUser(UserDto userDto);


    UserDto updateUser(long id, UserDto userDto);

    List<UserDto> getAllUser();

    void deleteUser(long id);

    void deleteAllUser();

    UserDto updateUserPatch(Long id, UserDto userDto);
}
