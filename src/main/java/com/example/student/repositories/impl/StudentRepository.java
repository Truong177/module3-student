package com.example.student.repositories.impl;

import com.example.student.dto.StudentDTO;
import com.example.student.models.Student;
import com.example.student.repositories.IStudentRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {

    @Override
    public List<StudentDTO> findAll() {
        List<StudentDTO> students = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement("SELECT id,student.name,address,point,classroom.name_classroom from student join classroom on student.id_class = classroom.id_class");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                Float point = resultSet.getFloat("point");
                String name_classroom = resultSet.getString("name_classroom");
                students.add(new StudentDTO(id, name, address, point,name_classroom));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public void save(Student student) {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection()
                    .prepareStatement("INSERT INTO student (name, address, point,id_class) VALUES (?, ?, ?,?)");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getAddress());
            preparedStatement.setFloat(3, student.getPoint());
            preparedStatement.setLong(4,student.getIdClass());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean deleteById(Long id) {
        boolean isDelete;
        try {
            PreparedStatement statement = BaseRepository.getConnection()
                    .prepareStatement("DELETE FROM student WHERE id=?");
            statement.setLong(1, id);
            isDelete = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isDelete;
    }

    @Override
    public List<StudentDTO> findByName(String name) {
        List<StudentDTO> result = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection()
                    .prepareStatement("SELECT * FROM student WHERE name LIKE ?");
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String studentName = resultSet.getString("name");
                String address = resultSet.getString("address");
                Float point = resultSet.getFloat("point");
                String name_classroom = resultSet.getString("id_class");
                result.add(new StudentDTO(id,studentName,address,point,name_classroom));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public Student findById(long id) {
        Student student = null;
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection()
                    .prepareStatement("SELECT * FROM student WHERE id=?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                Float point = resultSet.getFloat("point");
                student = new Student(id, name, address, point);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }

    @Override
    public void update(long id, Student student) {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection()
                    .prepareStatement("UPDATE student SET name=?, address=?, point=? WHERE id=?");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getAddress());
            preparedStatement.setFloat(3, student.getPoint());
            preparedStatement.setLong(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
