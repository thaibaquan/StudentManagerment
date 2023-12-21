package com.fullhouse.studentmanagerment.repository;

import com.fullhouse.studentmanagerment.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    User findUserByEmail(String email);

    @Query("SELECT u FROM User u " +
            "WHERE NOT EXISTS (SELECT 1 FROM Organization o WHERE u.id = o.headOfOrg) " +
            "AND NOT EXISTS (SELECT 1 FROM Subject s WHERE u.id = s.teacherId) " +
            "AND NOT EXISTS (SELECT 1 FROM UserSubject us WHERE u.id = us.userId)")
    List<User> findUsersWithoutRelations();
}
