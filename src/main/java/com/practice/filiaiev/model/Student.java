package com.practice.filiaiev.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String middleName;
    @Column(unique = true)
    private String email;
    private LocalDate dob;
    @Transient
    private List<DepartmentEntity> departments;
    @ElementCollection
    private List<Integer> departmentIds;
}
