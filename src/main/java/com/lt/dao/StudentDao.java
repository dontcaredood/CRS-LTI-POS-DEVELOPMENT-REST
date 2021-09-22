package com.lt.dao;

import com.lt.bean.Course;
import com.lt.bean.Student;
import com.lt.exceptions.StudentNotFoundException;


public interface StudentDao {
	
	/**
	 * Method to add student in database
	 * @param student
	 * @return integer id of the student
	 * @throws StudentNotRegisteredException
	 */
	public int addStudent(Student student) throws StudentNotFoundException;
	
/**
 * Method to get the student id
 * @param userId
 * @return integer id of the student
 */
	public int getStudentId(String userId);
	
	/**
	 * Method to see if the student is approved
	 * @param studentId
	 * @return boolean to check if the student is aproved
	 */
	public boolean isApproved(int studentId);
}