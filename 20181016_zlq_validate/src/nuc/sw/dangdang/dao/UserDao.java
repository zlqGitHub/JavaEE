package nuc.sw.dangdang.dao;

import java.util.Map;

import nuc.sw.dangdang.db.UserDatabase;
import nuc.sw.dangdang.entity.User;;

public class UserDao {
	//���һ���û�
	public void insertUser(User u) {
		UserDatabase.users.put(u.getUsername(), u);
	}
	
	//��ȡ�����û�
	public Map<String,User> listUsers(){
		return UserDatabase.users;
	}
}
