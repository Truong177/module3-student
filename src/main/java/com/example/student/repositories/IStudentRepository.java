package com.example.student.repositories;



import com.example.student.models.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();

    void save(Student student);

    Boolean deleteById(Long id);

    List<Student> findByName(String name);

    Student findById(long id);

    void update(long id, Student student);
}
