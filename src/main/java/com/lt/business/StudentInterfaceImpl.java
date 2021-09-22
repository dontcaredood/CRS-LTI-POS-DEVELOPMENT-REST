package com.lt.business;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lt.bean.Student;
import com.lt.dao.StudentDaoImpl;
import com.lt.exceptions.StudentNotFoundException;

public class StudentInterfaceImpl implements StudentInterface{
	
	private static Logger logger = LogManager.getLogger(StudentInterfaceImpl.class);
	StudentDaoImpl studentDaoImpl=  StudentDaoImpl.getInstance();
	private static volatile StudentInterfaceImpl instance=null;
	private StudentInterfaceImpl()
	{

	}
	
	public static StudentInterfaceImpl getInstance()
	{
		if(instance==null)
		{
			synchronized(StudentInterfaceImpl.class){
				instance=new StudentInterfaceImpl();
			}
		}
		return instance;
	}

	public int register(Student student) throws StudentNotFoundException{
		int studentId;
		try
		{
			
			studentId=studentDaoImpl.addStudent(student);
			
		}
		catch(StudentNotFoundException ex)
		{
			throw ex;
		}
		return studentId;
	}
	
	
	public int getStudentId(String userId) {
		return studentDaoImpl.getStudentId(userId);
	
	}
	
	
	public boolean isApproved(int studentId) {
		return studentDaoImpl.isApproved(studentId);
	}



	
}