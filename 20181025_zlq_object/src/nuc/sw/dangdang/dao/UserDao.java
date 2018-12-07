package nuc.sw.dangdang.dao;

import java.util.List;

import nuc.sw.dangdang.db.UserDatabase;
import nuc.sw.dangdang.entity.Student;

public class UserDao {
	//注册写入一个用户
	public void insertUser(Student u) {
		UserDatabase.users.add(u);
	}
	
	//获取所有用户
	public List<Student> listUsers(){
		return UserDatabase.users;
	}

}
