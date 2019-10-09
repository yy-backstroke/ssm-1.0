package com.yang.dao;

import com.yang.entity.Student;
import org.apache.ibatis.annotations.Select;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    @Select("select auto_increment from information_schema.`TABLES`\n" +
            " where table_name='student'")
    int nextId();
}