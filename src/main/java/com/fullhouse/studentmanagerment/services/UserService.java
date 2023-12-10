package com.fullhouse.studentmanagerment.services;

import com.fullhouse.studentmanagerment.dtos.UserDto;
import com.fullhouse.studentmanagerment.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void save(UserDto userDto);

    Boolean checkUserByEmail(String email);
}
