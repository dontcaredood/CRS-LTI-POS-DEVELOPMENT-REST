package com.lt.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.lt.bean.Course;
import com.lt.bean.RegisteredCourses;
import com.lt.dao.ProfessorDaoImpl;
import com.lt.exceptions.GradeNotAddedException;

@Service
public class ProfessorInterfaceImpl implements ProfessorInterface{
	private static Logger logger = LogManager.getLogger(ProfessorInterfaceImpl.class);
	
	private static volatile ProfessorInterfaceImpl instance=null;
	ProfessorDaoImpl professorDaoImpl= ProfessorDaoImpl.getInstance();
	
	private ProfessorInterfaceImpl()
	{

	}
	
	/**
	 * Method to make ProfessorOperation Singleton
	 * @return
	 */
	public static ProfessorInterfaceImpl getInstance()
	{
		if(instance==null)
		{
			// This is a synchronized block, when multiple threads will access this instance
			synchronized(ProfessorInterfaceImpl.class){
				instance=new ProfessorInterfaceImpl();
			}
		}
		return instance;
	}
	public boolean addGrade(int studentId,String courseCode,String grade) throws GradeNotAddedException {
		try
		{
			professorDaoImpl.addGrade(studentId, courseCode, grade);
		}
		catch(Exception ex)
		{
			throw new GradeNotAddedException(studentId);
		}
		return true;
	}
	
	
 
	public List<RegisteredCourses> viewEnrolledStudents(String profId){
		List<RegisteredCourses> enrolledStudents=new ArrayList<RegisteredCourses>();
		try
		{
			enrolledStudents=professorDaoImpl.getEnrolledStudents(profId);
		}
		catch(Exception ex)
		{
			logger.error(ex);
		}
		return enrolledStudents;
	}

	
	 
	public List<Course> getCourses(String profId) {
		//call the DAO class
		//get the courses for the professor
		List<Course> coursesOffered=new ArrayList<Course>();
		try
		{
			coursesOffered=professorDaoImpl.getCoursesByProfessor(profId);
		}
		catch(Exception ex)
		{
			logger.error(ex);
		}
		return coursesOffered;
	}
	
	 
	public String getProfessorById(String profId)
	{
		return professorDaoImpl.getProfessorById(profId);
	}


}