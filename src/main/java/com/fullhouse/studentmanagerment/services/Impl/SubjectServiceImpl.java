package com.fullhouse.studentmanagerment.services.Impl;

import com.fullhouse.studentmanagerment.models.Subject;
import com.fullhouse.studentmanagerment.repository.SubjectRepository;
import com.fullhouse.studentmanagerment.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    @Override
    public void save(Subject subject) {
        subjectRepository.save(subject);
    }

    @Override
    public List<Subject> findAll() {
        List<Subject> listS = subjectRepository.findAll();
        return listS;
    }

    @Override
    public List<Object[]> getSubjectDetails() {
        List<Object[]> list = subjectRepository.getSubjectDetails();
        return list;
    }
}
