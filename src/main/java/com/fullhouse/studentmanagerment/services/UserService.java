package com.fullhouse.studentmanagerment.services;

import com.fullhouse.studentmanagerment.dtos.UserDto;
import com.fullhouse.studentmanagerment.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    void save(UserDto userDto);

    Boolean checkUserByEmail(String email);

    List<User> findAll();

    User findUserByEmail(String email);
    Boolean checkPasswordUser(String email, String password);
    List<User> findUsersWithoutRelations();

}
