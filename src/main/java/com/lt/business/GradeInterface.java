package com.lt.business;

import java.util.List;

import com.lt.bean.Grade;
import com.lt.bean.GradeCard;
import com.lt.bean.Student;

public interface GradeInterface {

	public void generateGrade(GradeCard gc);
	public List<Grade> viewGrade();
	public List<Student> getStudentDetails();
	
}
