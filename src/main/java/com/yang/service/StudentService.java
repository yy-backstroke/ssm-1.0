package com.yang.service;

import com.yang.entity.Student;

import java.util.List;

public interface StudentService {
    public Student getStudentById(int id);
    public int insertStudent(Student record);
    public int updateStudent(Student record);
    public int getNextId();
    public void insertStudents(List<Student> students);
}
