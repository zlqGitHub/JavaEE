package nuc.sw.dangdang.service;

import java.util.List;

import nuc.sw.dangdang.dao.UserDao;
import nuc.sw.dangdang.entity.Student;

public class UserService {
	UserDao uDao = new UserDao();
	//注册添加一个用户
	public void insertUser(Student u) {
		uDao.insertUser(u);
	}
	
	//获取所有用户
	public List<Student> listUsers(){
		return uDao.listUsers();
	}

}
