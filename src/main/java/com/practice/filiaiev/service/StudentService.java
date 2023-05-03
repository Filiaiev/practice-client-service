package com.practice.filiaiev.service;

import com.practice.filiaiev.model.DepartmentEntity;
import com.practice.filiaiev.model.Student;
import com.practice.filiaiev.repository.DepartmentRepository;
import com.practice.filiaiev.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;

    public Student getStudent(Integer id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        enrichStudentWithDepartments(student);

        return student;
    }

    public List<Student> getStudents() {
        List<Student> students = studentRepository.findAll();

        students.forEach(this::enrichStudentWithDepartments);

        return students;
    }

    public void createStudent(Student saveStudent) {
        studentRepository.save(saveStudent);
    }

    private void enrichStudentWithDepartments(Student student) {
        List<DepartmentEntity> departments = departmentRepository.getDepartments(student.getDepartmentIds());

        student.setDepartments(departments);
    }
}
