package com.fullhouse.studentmanagerment.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Subject {
    @Id
    private UUID id;

    @Column(name = "teacher_id")
    private char teacherId;

    @Column(name = "organization_id")
    private char organizationId;

    @Column(name = "name")
    private String name;
}
