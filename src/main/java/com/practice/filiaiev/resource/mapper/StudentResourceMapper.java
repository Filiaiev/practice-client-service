package com.practice.filiaiev.resource.mapper;

import com.practice.filiaiev.model.Student;
import com.practice.filiaiev.resource.StudentCreateRO;
import com.practice.filiaiev.resource.StudentRO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentResourceMapper {

    StudentRO mapStudentToStudentRO(Student student);

    List<StudentRO> mapStudentToStudentROs(List<Student> students);

    Student mapStudentROToStudent(StudentCreateRO studentCreateRO);
}
