package com.yang.entity;

public class Student {
    private Integer id;

    private String password;

    private String name="default";

    private Integer age=0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }


    public Student(String name, Integer age) {
        this.age = age;
        this.name = name;
    }

    public Student(Integer id, String password, String name, Integer age) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.age = age;
    }

    public Student(Integer id, String password) {
        this.id = id;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}