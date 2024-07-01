package com.example.student.services.impl;



import com.example.student.models.Student;
import com.example.student.repositories.IStudentRepository;
import com.example.student.repositories.impl.StudentRepository;
import com.example.student.services.IStudentService;

import java.util.List;

public class StudentService implements IStudentService {

    private static IStudentRepository studentRepository = new StudentRepository();

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Boolean deleteById(Long id) {
        return studentRepository.deleteById(id);
    }

    @Override
    public List<Student> findByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public Student findById(long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void update(long id, Student student) {
        studentRepository.update(id,student);
    }
}
