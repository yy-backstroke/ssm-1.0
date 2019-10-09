import javax.annotation.Resource;


import com.yang.entity.Student;
import com.yang.serviceImp.StudentServiceImp;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.yang.service.StudentService;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring/spring-mybatis.xml"})
public class TestMybatis {
    private static Logger logger = Logger.getLogger(TestMybatis.class);
//    	private ApplicationContext ac = null;
    @Resource
    private StudentService studentService = null;

//	@Before
//	public void before() {
//		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        studentService = (service.StudentService) ac.getBean("studentService");
//	}

    @Test
    public void test1() {
        Student student = studentService.getStudentById(10000001);
        // System.out.println(user.getUserName());
        // logger.info("值："+user.getUserName());
        logger.info(JSON.toJSONString(student));
    }
    @Transactional
    @Test
    public void testTransaction(){
        List<Student> students = new ArrayList<Student>();
        for(int i=1;i<=2;i++){
            Student student = new Student();
//            student.setId(11000000+i);
            student.setAge(i);
            int j=1/0;
            student.setPassword(i+"111111");
            student.setName("测试"+i);
            students.add(student);
        }
        this.studentService.insertStudents(students);
    }
}