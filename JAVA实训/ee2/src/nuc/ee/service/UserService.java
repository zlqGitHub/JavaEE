package nuc.ee.service;

import java.util.ArrayList;
import java.util.List;

import nuc.ee.dao.UserDao;
import nuc.ee.model.Company;
import nuc.ee.model.GignUp;
import nuc.ee.model.Teacher;
import nuc.ee.model.User;
import nuc.ee.model.UserLogin;

public class UserService {
	UserDao uDao = new UserDao();
	//注册信息时判断是否已注册
	public int select_user(User u) {
		int i = uDao.regist_select(u);
		return i;
	}
	
	//将注册信息写入表中
	public int insert_user(User u) {
		int i = uDao.user_insert(u);
		return i;
	}
	
	//用户登录
	public User login_user(UserLogin u) {
		User user = new User();
		user = uDao.login_select(u);
		return user;
	}
	
	//用户报名前获取可报名的次数
	public int get_change(int userid) {
		int change = uDao.get_change(userid);
		return change;
	}
	
	//将报名信息写入表中
	public void insert_user(GignUp gp,int num,String time) {
		uDao.insert_user(gp, num, time);
	}
	
	//获取公司信息
	public List<Company> get_company(){
		List<Company> comList = new ArrayList<Company>();
		comList = uDao.get_company();
		return comList;
	}
	
	//获取教师信息
	public List<Teacher> get_teacher(){
		List<Teacher> teaList = new ArrayList<Teacher>();
		teaList = uDao.get_teacher();	
		return teaList;
	}
	
	

}
