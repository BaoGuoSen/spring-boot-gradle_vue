package mybatis.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mybatis.demo.dao.StudentDao;
import mybatis.demo.entity.Student;
import mybatis.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentDao studentDao;
	
	@Override
	public List<Student> findAllStudents() {
		return this.studentDao.findAllStudents();
	}
	
	@Override
	public void saveStudent(Student student) {
		this.studentDao.saveStudent(student);
	}
	
	@Override
	public Student findbyid(int id) {
		// TODO Auto-generated method stub
		return studentDao.findbyid(id);
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		this.studentDao.deleteStudent(id);
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		this.studentDao.updateStudent(student);
	}

	@Override
	public List<Student> findbyname(String name) {
		// TODO Auto-generated method stub
		return studentDao.findbyname(name);
	}
}
