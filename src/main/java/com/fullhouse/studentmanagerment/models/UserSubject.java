package com.fullhouse.studentmanagerment.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSubject {
    @Id
    private UUID id;
    @Column(name = "user_id")
    private char userId;

    @Column(name = "subject_id")
    private char subjectId;

    @Column(name = "score")
    private Double score;
}
