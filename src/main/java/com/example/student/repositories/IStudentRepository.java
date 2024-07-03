package com.example.student.repositories;



import com.example.student.dto.StudentDTO;
import com.example.student.models.Student;

import java.util.List;

public interface IStudentRepository {
    List<StudentDTO> findAll();

    void save(Student student);

    Boolean deleteById(Long id);

    List<StudentDTO> findByName(String name);

    Student findById(long id);

    void update(long id, Student student);
}
