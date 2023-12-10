package com.fullhouse.studentmanagerment.repository;

import com.fullhouse.studentmanagerment.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    User findUserByEmail(String email);
}
