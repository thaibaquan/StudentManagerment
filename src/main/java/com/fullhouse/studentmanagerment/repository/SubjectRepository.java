package com.fullhouse.studentmanagerment.repository;

import com.fullhouse.studentmanagerment.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface SubjectRepository extends JpaRepository<Subject, UUID> {
    @Query("SELECT\n" +
            "    us.name AS subject_name,\n" +
            "    org.name AS organization_name,\n" +
            "    org.orgType,\n" +
            "    u.name AS user_name\n" +
            "FROM\n" +
            "    Subject us\n" +
            "    JOIN User u ON us.teacherId = u.id\n" +
            "    JOIN Organization org ON us.organizationId = org.id")
    List<Object[]> getSubjectDetails();
}
