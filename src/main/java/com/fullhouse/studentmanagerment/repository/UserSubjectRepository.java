package com.fullhouse.studentmanagerment.repository;

import com.fullhouse.studentmanagerment.models.UserSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UserSubjectRepository extends JpaRepository<UserSubject, UUID> {
//    @Query("SELECT\n" +
//            "    us.score AS subject_name,\n" +
//            "    s.name AS organization_name,\n" +
//            "    u.name AS user_name\n" +
//            "FROM\n" +
//            "    UserSubject us\n" +
//            "    JOIN User u ON us.userId = u.id\n" +
//            "    JOIN Subject s ON us.subjectId = s.id")
    @Query("SELECT\n" +
            "    sub.name AS subject_name,\n" +
            "    us.score,\n" +
            "    org.name AS organization_name,\n" +
            "    org.orgType,\n" +
            "    u.name AS user_name\n" +
            "FROM\n" +
            "    UserSubject us\n" +
            "    JOIN Subject sub ON us.subjectId = sub.id\n" +
            "    JOIN User u ON us.userId = u.id\n" +
            "    JOIN Organization org ON sub.organizationId = org.id")
    List<Object[]> getSubjectDetails();
}
