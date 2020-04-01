package mybatis.demo.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import mybatis.demo.entity.Student;
import mybatis.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentService studentService;
	
	
	@PostMapping("addStudent")
	public void saveStudent(@RequestBody Student student) {
		LOGGER.info("新增"+student.toString());
		this.studentService.saveStudent(student);
	}
	
	
	@GetMapping("findAllStudents")
	public List<Student> findAllStudents() {
		return studentService.findAllStudents();
	}
	
	@GetMapping("/findbyid")
	public Student findbyid(int id)
	{
		Student student=studentService.findbyid(id);
		LOGGER.info("查询"+student.toString());
		return student;
	}
	
	@GetMapping("/findbyname")
	public List<Student> findbyid(String name)
	{
		LOGGER.info("查找名字中有"+name+"的学生");
		return studentService.findbyname(name);
	}
	
	@GetMapping("/deletebyid")
	public void delete(int id)
	{
		Student student=findbyid(id);
		LOGGER.info("删除"+student.toString());
		this.studentService.deleteStudent(id);
	}
	
	@PostMapping("/updatebyid")
	public void update(@RequestBody Student student)
	{
		Student oldStudent=findbyid(student.getId());
		LOGGER.info("把"+oldStudent.toString()+"修改为"+student.toString());
		this.studentService.updateStudent(student);
	}
	
	 @GetMapping("/uploadfileurl")
		public void uploadfileurl(@Param("id")int id,@Param("FileUrl")String FileUrl)
		{
			this.studentService.uploadfile(id, FileUrl);
			
		}
	 @GetMapping("/uploadimgurl")
		public void uploadimgurl(@Param("id")int id,@Param("ImgUrl")String ImgUrl)
		{
			this.studentService.uploadimg(id, ImgUrl);
			
		}
}
