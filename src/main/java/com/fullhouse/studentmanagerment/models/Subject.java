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
@Table(name = "subject")
public class Subject {
    @Id
    @Column(name = "id", length = 36, nullable = false)
    private String id = UUID.randomUUID().toString();

    @Column(name = "teacher_id", length = 36)
    private String teacherId;

    @Column(name = "organization_id", length = 36)
    private String organizationId;

    @Column(name = "name", length = 255, nullable = false)
    private String name;
}
