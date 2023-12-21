package com.fullhouse.studentmanagerment.services.Impl;

import com.fullhouse.studentmanagerment.models.UserSubject;
import com.fullhouse.studentmanagerment.repository.UserSubjectRepository;
import com.fullhouse.studentmanagerment.services.UserSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSubjectServiceImpl implements UserSubjectService {

    @Autowired
    private UserSubjectRepository userSubjectRepository;
    @Override
    public void save(UserSubject userSubject) {
        userSubjectRepository.save(userSubject);
    }

    @Override
    public List<UserSubject> findAll() {
        List<UserSubject> listUS = userSubjectRepository.findAll();
        return listUS;
    }

    @Override
    public List<Object[]> getSubjectDetails() {
        List<Object[]> listS = userSubjectRepository.getSubjectDetails();
        return listS;
    }
}
