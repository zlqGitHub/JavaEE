package nuc.ee.service;

import java.util.ArrayList;
import java.util.List;

import nuc.ee.dao.CourseDao;
import nuc.ee.model.Course;

public class CourseService {
	CourseDao cd = new CourseDao();
	List<Course> csList = new ArrayList<Course>();
	
	public List<Course> get_course() {
		csList = cd.course_select();
		return csList;
	}
	

}
