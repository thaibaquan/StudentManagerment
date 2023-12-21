package com.fullhouse.studentmanagerment.services;

import com.fullhouse.studentmanagerment.models.Subject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubjectService {
    void save(Subject subject);
    List<Subject> findAll();
    List<Object[]> getSubjectDetails();
}
