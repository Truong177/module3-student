package com.example.student.dto;

public class StudentDTO {
    private Long id;
    private String name;
    private String address;
    private Float point;
    private String name_classroom;

    public StudentDTO() {
    }

    public StudentDTO(Long id, String name, String address, Float point, String name_classroom) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.point = point;
        this.name_classroom = name_classroom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getPoint() {
        return point;
    }

    public void setPoint(Float point) {
        this.point = point;
    }

    public String getName_classroom() {
        return name_classroom;
    }

    public void setName_classroom(String name_classroom) {
        this.name_classroom = name_classroom;
    }
}
