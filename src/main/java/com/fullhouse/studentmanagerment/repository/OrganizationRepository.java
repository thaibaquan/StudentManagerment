package com.fullhouse.studentmanagerment.repository;

import com.fullhouse.studentmanagerment.models.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface OrganizationRepository extends JpaRepository<Organization, UUID> {

    @Query("SELECT u.name AS user_name, u.email, o.orgType, o.name\n" +
            "FROM User u\n" +
            "INNER JOIN Organization o ON u.id = o.headOfOrg")
    List<Object[]> findUserNameEmailAndOrgType();

    List<Organization> findOrganizationById(String id);
}
