package com.practice.filiaiev.resource;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class StudentRO {

    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private LocalDate dob;
    private List<DepartmentEntityRO> departments;
}
