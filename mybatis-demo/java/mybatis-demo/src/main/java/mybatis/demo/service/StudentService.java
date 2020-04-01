package mybatis.demo.service;

import java.util.List;

import mybatis.demo.entity.Student;

public interface StudentService {
	
	List<Student> findAllStudents();
	
	void saveStudent(Student student);
	
	Student findbyid(int id);
	
	List<Student> findbyname(String name);
	
	void deleteStudent(int id);
	
	void updateStudent(Student student);
}
