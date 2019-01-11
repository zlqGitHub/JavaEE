package nuc.ee.action;

import java.util.ArrayList;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import nuc.ee.model.Course;
import nuc.ee.service.CourseService;


@SuppressWarnings("serial")
public class LoginAction extends ActionSupport{
	private Course course = new Course();
	int num;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	CourseService cs = new CourseService();
	
	List<Course> csList = new ArrayList<Course>();
	
	public List<Course> getCsList() {
		return csList;
	}

	public void setCsList(List<Course> csList) {
		this.csList = csList;
	}

	public String LoginMethod() {
		csList = cs.get_course();
		num = (int) ((Math.ceil((csList.size()/2.0))*187));
		System.out.println(num);
		
		return "success";
	}
	
}
