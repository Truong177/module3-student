package com.example.student.services.impl;

import com.example.student.models.Classroom;
import com.example.student.repositories.IClassroomRepository;
import com.example.student.repositories.impl.ClassroomRepository;
import com.example.student.services.IClassroomService;

import java.util.List;

public class ClassroomService implements IClassroomService {
    private IClassroomRepository classroomRepository = new ClassroomRepository();
    @Override
    public List<Classroom> findAll() {
        return classroomRepository.findAll();
    }
}
