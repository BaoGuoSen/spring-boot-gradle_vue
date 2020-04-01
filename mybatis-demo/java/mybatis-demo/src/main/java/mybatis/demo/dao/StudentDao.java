package mybatis.demo.dao;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;

import mybatis.demo.entity.Student;

@Mapper
public interface StudentDao {
	List<Student> findAllStudents();
	
	void saveStudent(Student student);
	
	Student findbyid(int id);
	
	List<Student> findbyname(String name);
	
	void deleteStudent(int id);
	
	void updateStudent(Student student);
}
