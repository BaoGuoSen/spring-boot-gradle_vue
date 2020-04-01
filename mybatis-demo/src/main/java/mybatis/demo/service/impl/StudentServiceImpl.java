package mybatis.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mybatis.demo.dao.StudentDao;
import mybatis.demo.entity.Student;
import mybatis.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentDao studentDao;
	
	@Override
	@Transactional
	public List<Student> findAllStudents() {
		return this.studentDao.findAllStudents();
	}
	
	@Override
	@Transactional
	public void saveStudent(Student student) {
		this.studentDao.saveStudent(student);
	}
	
	@Override
	@Transactional
	public Student findbyid(int id) {
		// TODO Auto-generated method stub
		return studentDao.findbyid(id);
	}

	@Override
	@Transactional
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		this.studentDao.deleteStudent(id);
	}

	@Override
	@Transactional
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		this.studentDao.updateStudent(student);
	}

	@Override
	@Transactional
	public List<Student> findbyname(String name) {
		// TODO Auto-generated method stub
		return studentDao.findbyname(name);
	}

	@Override
	public void uploadfile(int id, String FileUrl) {
		// TODO Auto-generated method stub
		this.studentDao.uploadfile(FileUrl,id);
	}

	@Override
	public void uploadimg(int id, String ImgUrl) {
		// TODO Auto-generated method stub
		this.studentDao.uploadimg(ImgUrl,id);
	}
}
