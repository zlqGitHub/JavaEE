package nuc.sw.dangdang.dao;

import java.util.Map;

import nuc.sw.dangdang.db.UserDatabase;
import nuc.sw.dangdang.entity.User;;

public class UserDao {
	//添加一个用户
	public void insertUser(User u) {
		UserDatabase.users.put(u.getUsername(), u);
	}
	
	//获取所有用户
	public Map<String,User> listUsers(){
		return UserDatabase.users;
	}
}
