package com.fullhouse.studentmanagerment.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_subject")
public class UserSubject {
    @Id
    @Column(name = "id", length = 36, nullable = false)
    private String id = UUID.randomUUID().toString();

    @Column(name = "user_id", length = 36, nullable = false)
    private String userId;

    @Column(name = "subject_id", length = 36, nullable = false)
    private String subjectId;

    @Column(name = "score")
    private Double score;
}
