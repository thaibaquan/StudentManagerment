package com.fullhouse.studentmanagerment.models;

import com.fullhouse.studentmanagerment.common.constants.OrganizationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "organization")
public class Organization {
    @Id
    @Column(name = "id", nullable = false)
    private String id = UUID.randomUUID().toString();

    @Column(name = "parent_id")
    private String parentId;

    @Enumerated(EnumType.STRING)
    @Column(name = "org_type", nullable = false)
    private OrganizationType orgType;

    @Column(name = "head_of_org", nullable = false)
    private String headOfOrg;

    @Column(name = "name", nullable = false)
    private String name;

}
