package com.lt.business;

import java.util.List;

import com.lt.bean.Grade;
import com.lt.bean.Student;

public interface GradeCardInterface {

	public void getGradeInfo(int id);
	public List<Grade> getGrade();
	public List<Student> getStduentDetails();
}
