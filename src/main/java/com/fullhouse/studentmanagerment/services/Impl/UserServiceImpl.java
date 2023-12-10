package com.fullhouse.studentmanagerment.services.Impl;

import com.fullhouse.studentmanagerment.dtos.UserDto;
import com.fullhouse.studentmanagerment.models.Organization;
import com.fullhouse.studentmanagerment.models.User;
import com.fullhouse.studentmanagerment.repository.UserRepository;
import com.fullhouse.studentmanagerment.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void save(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        userRepository.save(user);
    }

    @Override
    public Boolean checkUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        if(user == null) return false;
        return true;
    }
}
