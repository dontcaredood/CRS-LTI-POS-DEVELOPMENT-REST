package com.lt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lt.bean.Professor;
import com.lt.bean.RegisteredCourses;
import com.lt.business.ProfessorInterfaceImpl;
import com.lt.contants.Gender;
import com.lt.contants.Role;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

	@Autowired
	private ProfessorInterfaceImpl professorImpl;
	
	@GetMapping
	@ResponseBody
	public Professor showProfessor()
	{
		Professor professor=new Professor();
		professor.setAddress("Pune");
		professor.setCountry("India");
		professor.setDepartment("CS");
		professor.setGender(Gender.MALE.getName(1));
		professor.setName("REhan");
		professor.setPassword("int@123");
		professor.setRole(Role.PROFESSOR);
		
		return professor;
	}
	
	@GetMapping(value = "professor/{profId}")
	@ResponseBody
	public List<RegisteredCourses> viewEnrolledStudents(@PathVariable("profId") String professorId)
	{
		looger.info(professorId);
		List<RegisteredCourses> list=professorImpl.viewEnrolledStudents(professorId);
		return list;
	}
	
	
	
}
