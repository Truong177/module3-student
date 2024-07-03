package com.example.student.repositories;

import com.example.student.models.Classroom;

import java.util.List;

public interface IClassroomRepository {
    List<Classroom> findAll();
}
