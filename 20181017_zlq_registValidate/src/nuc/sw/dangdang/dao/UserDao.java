package nuc.sw.dangdang.dao;

import java.util.List;

import nuc.sw.dangdang.db.*;
import nuc.sw.dangdang.entity.User;

public class UserDao {
	//写入一个用户
	public void insertUser(User u) {
		UserDatabase.users.add(u);
	}
	//获取所有用户
	public List<User> listUsers(){
		return UserDatabase.users;
	}

}
