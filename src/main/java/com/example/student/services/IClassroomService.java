package com.example.student.services;

import com.example.student.models.Classroom;

import java.util.List;

public interface IClassroomService {
    List<Classroom> findAll();
}
