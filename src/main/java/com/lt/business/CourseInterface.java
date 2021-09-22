package com.lt.business;

import java.util.List;

import com.lt.bean.Course;

public interface CourseInterface {
public void addCourse(Course course);
public List<Course> getCourse();
public boolean removeCourse(int id);

}
