package com.yang.controller;

import com.yang.service.StudentService;
import com.yang.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


//@ContextConfiguration(locations = {"classpath:spring/spring-mybatis.xml"})
@Controller
public class StudentController {
//    @RequestMapping(value = "/student", method = RequestMethod.GET)
//    public ModelAndView student() {
//        return new ModelAndView("student", "command", new Student());
//    }
    @Resource(name="student")
    private StudentService studentService = null;
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin(ModelMap model){

        model.addAttribute("message", "请登录系统");
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Student student, ModelMap model) {
        int id= student.getId();
        String password=student.getPassword();
        String message="系统错误";
        Student studentLoad=studentService.getStudentById(id);
        if(studentLoad==null||
                !password.equals(studentLoad.getPassword())){
            message="学号或密码错误，请核对信息！";
            model.addAttribute("message", message);
            return "errorLogin";
        }
        else{
            message="学生登录成功！";
            model.addAttribute("message", message);
            model.addAttribute("name", studentLoad.getName());
            model.addAttribute("id",id);
            model.addAttribute("age", studentLoad.getAge());
            return "displayStudent";
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String toRegister(ModelMap model){
        String message="系统错误";
        int id=studentService.getNextId();
        model.addAttribute("message","请注册用户");
        model.addAttribute("id",id);
        return "register";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String Register(HttpServletRequest request, ModelMap model){
        String id= request.getParameter("id");
        String password1= request.getParameter("password1");
        String password2= request.getParameter("password2");
        String message="系统错误";
        if(!password1.equals(password2)) {
            message="两次输入的密码不一致,重新注册";
            model.addAttribute("message", message);
            model.addAttribute("id",id);
            return "register";
        }
        Student student= new Student();
        student.setId(Integer.parseInt(id));student.setPassword(password1);
        studentService.insertStudent(student);
        message="用户注册成功,您的学号是"+id+",请再次登陆";
        model.addAttribute("message", message);
        return "login";
    }
    @RequestMapping(value = "/updateStudent", method = RequestMethod.GET)
    public String toUpdate(HttpServletRequest request, ModelMap model){
        String id= request.getParameter("id");
        model.addAttribute("id", id);
        return "updateStudent";
    }
    @RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
    public String Update(HttpServletRequest request, Student student, ModelMap model){
        int id= Integer.parseInt(request.getParameter("id"));
        String name=student.getName();
        Integer age=student.getAge();
        String message="系统错误";
        Student newstudent = new Student();
        newstudent.setName(name);newstudent.setAge(age);newstudent.setId(id);
        studentService.updateStudent(newstudent);
        message="学生信息更新成功";
        model.addAttribute("message", message);
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "displayStudent";
    }
}

