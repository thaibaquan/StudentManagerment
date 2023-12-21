package com.fullhouse.studentmanagerment.services;

import com.fullhouse.studentmanagerment.models.Organization;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrganizationService {
    void save(Organization organization);
    List<Organization> findAll();
    List<Object[]> findUserNameEmailAndOrgType();
    List<Organization> findOrganizationById(String id);
}
