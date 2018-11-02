package nuc.sw.dangdang.service;

import java.util.List;

import nuc.sw.dangdang.dao.UserDao;
import nuc.sw.dangdang.entity.User;

public class UserService {
	UserDao uDao = new UserDao();
	//写入一个用户
	public void insertUser(User u) {
		uDao.insertUser(u);
	}
	//获取所有用户
	public List<User> listUsers(){
		return uDao.listUsers();
	}
	
}
