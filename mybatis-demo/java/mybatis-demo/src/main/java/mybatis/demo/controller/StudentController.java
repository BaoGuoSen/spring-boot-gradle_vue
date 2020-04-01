package mybatis.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mybatis.demo.entity.Student;
import mybatis.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	@PostMapping("addStudent")
	public void saveStudent(@RequestBody Student student) {
		this.studentService.saveStudent(student);
	}
	
	
	@GetMapping("findAllStudents")
	public List<Student> findAllStudents() {
		return studentService.findAllStudents();
	}
	
	@GetMapping("/findbyid")
	public Student findbyid(int id)
	{
		return studentService.findbyid(id);
	}
	
	@GetMapping("/findbyname")
	public List<Student> findbyid(String name)
	{
		return studentService.findbyname(name);
	}
	
	@GetMapping("/deletebyid")
	public void delete(int id)
	{
		this.studentService.deleteStudent(id);
	}
	
	@PostMapping("/updatebyid")
	public void update(@RequestBody Student student)
	{
		this.studentService.updateStudent(student);
	}
}
