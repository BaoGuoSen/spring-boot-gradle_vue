package mybatis.demo.entity;

import java.util.Date;

public class Student {
	 int id;
	 String name;
	 String sex;
	 int grade;
	 String school;
	 String major;
	 String hobby;
	 Date date;
	 
	
	public Student(int id, String name, String sex, int grade, String school, String major, String hobby, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.grade = grade;
		this.school = school;
		this.major = major;
		this.hobby = hobby;
		this.date = date;
	}
	public Student()
	{
		super();
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * @return the grade
	 */
	public int getGrade() {
		return grade;
	}
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(int grade) {
		this.grade = grade;
	}
	/**
	 * @return the school
	 */
	public String getSchool() {
		return school;
	}
	/**
	 * @param school the school to set
	 */
	public void setSchool(String school) {
		this.school = school;
	}
	/**
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}
	/**
	 * @param major the major to set
	 */
	public void setMajor(String major) {
		this.major = major;
	}
	/**
	 * @return the hobby
	 */
	public String getHobby() {
		return hobby;
	}
	/**
	 * @param hobby the hobby to set
	 */
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
}