package com.lt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.lt.bean.Student;
import com.lt.contants.Constants;
import com.lt.contants.Gender;
import com.lt.contants.Role;
import com.lt.exceptions.StudentNotFoundException;
import com.lt.utils.DBUtils;


public class StudentDaoImpl implements StudentDao {
	private static Logger logger = LogManager.getLogger(StudentDaoImpl.class);
	
	private static volatile StudentDaoImpl instance=null;
	private StudentDaoImpl()
	{

	}
	
	public static StudentDaoImpl getInstance()
	{
		if(instance==null)
		{
			synchronized(StudentDaoImpl.class){
				instance=new StudentDaoImpl();
			}
		}
		return instance;
	}

	public int addStudent(Student student) throws StudentNotFoundException{
		Connection connection=DBUtils.getConnection();
		int studentId=0;
		try
		{
			//open db connection
			PreparedStatement preparedStatement=connection.prepareStatement(Constants.ADD_USER_QUERY);
			preparedStatement.setString(1, student.getUserId());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getPassword());
			preparedStatement.setString(4, student.getRole().toString());
			preparedStatement.setString(5, student.getGender().toString());
			preparedStatement.setString(6, student.getAddress());
			int rowsAffected=preparedStatement.executeUpdate();
			if(rowsAffected==1)
			{
				//add the student record
				//"insert into student (userId,branchName,batch,isApproved) values (?,?,?,?)";
				PreparedStatement preparedStatementStudent;
				preparedStatementStudent=connection.prepareStatement(Constants.ADD_STUDENT);//,Statement.RETURN_GENERATED_KEYS
				preparedStatementStudent.setString(1,student.getUserId());
				preparedStatementStudent.setString(2, student.getBranchName());
				preparedStatementStudent.setString(3, "N");
				preparedStatementStudent.executeUpdate();
				ResultSet results=preparedStatementStudent.getGeneratedKeys();
				if(results.next())
					studentId=results.getInt(1);
				System.out.println(studentId);
			}
			
			
		}
		catch(Exception ex)
		{
			//throw new StudentNotFoundException(studentId);
		System.out.println(ex.getMessage());
		ex.printStackTrace();
		}
		/*
		 * finally { try { connection.close(); } catch (SQLException e) {
		 * System.out.println(e.getMessage()+"SQL error"); e.printStackTrace(); } }
		 */
		return studentId;
	}
	

	public int getStudentId(String userId) {
		Connection connection=DBUtils.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(Constants.GET_STUDENT_ID);
			statement.setString(1, userId);
			ResultSet rs = statement.executeQuery();
			
			if(rs.next())
			{
				return rs.getInt("studentId");
			}
				
		}
		catch(SQLException e)
		{
			logger.error(e.getMessage());
		}
		
		return 0;
	}
	
	
	public boolean isApproved(int studentId) {
		Connection connection=DBUtils.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(Constants.IS_APPROVED);
			statement.setInt(1, studentId);
			ResultSet rs = statement.executeQuery();
			
			if(rs.next())
			{
				if(rs.getString("isApproved").equalsIgnoreCase("Y")) {
					return true;
				}else {
					return false;
				}
				
			}
				
		}
		catch(SQLException e)
		{
			logger.error(e.getMessage());
		}
		
		return false;
	}

	/*
	 * public static void main(String[] args) throws StudentNotFoundException {
	 * StudentDaoImpl std=StudentDaoImpl.getInstance(); Student student=new
	 * Student();
	 * 
	 * student.setUserId("123d"); student.setAddress("Pune");
	 * student.setBranchName("ESS"); student.setName("Test");
	 * student.setPassword("test@123"); student.setRole(Role.STUDENT);
	 * student.setGender(Gender.MALE.getName(1));
	 * 
	 * System.out.println("Std ID : "+std.addStudent(student));
	 * 
	 * }
	 */
}