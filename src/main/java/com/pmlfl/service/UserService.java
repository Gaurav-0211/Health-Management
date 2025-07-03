package com.pmlfl.service;


import com.pmlfl.dto.UserDto;
import com.pmlfl.models.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    Optional<User> getUserById(long id);

    UserDto createUser(UserDto userDto);


}
