package com.fullhouse.studentmanagerment.services;

import com.fullhouse.studentmanagerment.models.UserSubject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserSubjectService {
    void save (UserSubject userSubject);
    List<UserSubject> findAll();
    List<Object[]> getSubjectDetails();
}
