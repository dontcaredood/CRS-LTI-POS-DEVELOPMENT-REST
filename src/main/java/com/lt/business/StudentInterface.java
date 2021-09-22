package com.lt.business;

import com.lt.bean.Student;
import com.lt.exceptions.StudentNotFoundException;

public interface StudentInterface {
	
	/**
	 * Method to register the student
	 * @param student
	 * @return int id of the student
	 * @throws StudentNotRegisteredException
	 */
	public int register(Student student) throws StudentNotFoundException; 
	/**
	 * Mthod to get the id of student
	 * @param userId
	 * @return int id of student
	 */
	public int getStudentId(String userId);
	
	/**
	 * Method to check the student approval
	 * @param studentId
	 * @return boolean to check if the student is approved
	 */
    public boolean isApproved(int studentId);
}