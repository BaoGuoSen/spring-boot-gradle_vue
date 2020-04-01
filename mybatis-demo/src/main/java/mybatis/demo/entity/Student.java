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
	 String ImgUrl;
	 String FileUrl;
	
	
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

	/**
	 * @return the imgUrl
	 */
	public String getImgUrl() {
		return ImgUrl;
	}

	/**
	 * @param imgUrl the imgUrl to set
	 */
	public void setImgUrl(String imgUrl) {
		ImgUrl = imgUrl;
	}

	/**
	 * @return the fileUrl
	 */
	public String getFileUrl() {
		return FileUrl;
	}

	/**
	 * @param fileUrl the fileUrl to set
	 */
	public void setFileUrl(String fileUrl) {
		FileUrl = fileUrl;
	}

	public Student(int id, String name, String sex, int grade, String school, String major, String hobby, Date date,
			String imgUrl, String fileUrl) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.grade = grade;
		this.school = school;
		this.major = major;
		this.hobby = hobby;
		this.date = date;
		ImgUrl = imgUrl;
		FileUrl = fileUrl;
	}

	public Student()
	{
		super();
	}
	
	public String toString()
	{
		return "id="+this.id+"  name="+this.name+"  sex="+this.sex+"  grade="+this.grade+"  school="+this.school+
				"  major="+this.major+"  hobby="+this.hobby;
	}
	
}