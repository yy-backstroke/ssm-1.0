package com.yang.serviceImp;


import javax.annotation.Resource;

import com.yang.dao.StudentMapper;
import com.yang.entity.Student;
import org.springframework.stereotype.Service;

import com.yang.service.StudentService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("student")
public class StudentServiceImp implements StudentService {
    @Resource
    private StudentMapper studentMapper;

    @Override
    public Student getStudentById(int userId) {
        // TODO Auto-generated method stub
        return this.studentMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int insertStudent(Student record) {
        return this.studentMapper.insertSelective(record);
    }

    @Override
    public int updateStudent(Student record) {
        return this.studentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int getNextId() {
        return this.studentMapper.nextId();
    }

//    @Transactional
    @Override
    public void insertStudents(List<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            if (i < 2) {
                this.studentMapper.insertSelective(students.get(i));
            } else {
                throw new RuntimeException();
            }
        }
    }

}

