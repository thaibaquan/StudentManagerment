package com.fullhouse.studentmanagerment.services.Impl;


import com.fullhouse.studentmanagerment.models.Organization;
import com.fullhouse.studentmanagerment.repository.OrganizationRepository;
import com.fullhouse.studentmanagerment.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiecImpl implements OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;
    @Override
    public void save(Organization organization) {
        organizationRepository.save(organization);
    }

    @Override
    public List<Organization> findAll() {
        List<Organization> organizations = organizationRepository.findAll();
        return organizations;
    }

    @Override
    public List<Object[]> findUserNameEmailAndOrgType() {
        List<Object[]> listOU = organizationRepository.findUserNameEmailAndOrgType();
        return listOU;
    }

    @Override
    public List<Organization> findOrganizationById(String id) {
        List<Organization> listorg = organizationRepository.findOrganizationById(id);
        return listorg;
    }


}
