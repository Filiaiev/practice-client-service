package com.practice.filiaiev.resource;

import com.practice.filiaiev.model.Student;
import com.practice.filiaiev.resource.mapper.StudentResourceMapper;
import com.practice.filiaiev.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final StudentResourceMapper studentMapper;

    @GetMapping("/{id}")
    public StudentRO getStudent(@PathVariable Integer id) {
        return studentMapper.mapStudentToStudentRO(studentService.getStudent(id));
    }

    @GetMapping
    public List<StudentRO> getStudents() {
        return studentMapper.mapStudentToStudentROs(studentService.getStudents());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody StudentCreateRO student) {
        Student saveStudent = studentMapper.mapStudentROToStudent(student);
        studentService.createStudent(saveStudent);
    }
}
