package nuc.sw.dangdang.dao;

import java.util.List;

import nuc.sw.dangdang.db.UserDatabase;
import nuc.sw.dangdang.entity.User;

public class UserDao {
	//ע��д��һ���û�
	public void insertUser(User u) {
		UserDatabase.users.add(u);
	}
	
	//��ȡ�����û�
	public List<User> listUsers(){
		return UserDatabase.users;
	}

}
