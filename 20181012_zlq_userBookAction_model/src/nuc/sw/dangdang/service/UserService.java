package nuc.sw.dangdang.service;

import java.util.Map;

import nuc.sw.dangdang.dao.UserDao;
import nuc.sw.dangdang.db.UserDatabase;
import nuc.sw.dangdang.entity.User;

public class UserService {
	private UserDao uDao = new UserDao();
	
	//��һ���û�
	public void insertUser(User u) {
		uDao.insertUser(u);
	}
	
	//�ж��û��Ƿ�Ϸ�
	public boolean isValidUser(User u) {
		boolean flag = false;
		Map<String,User> users = UserDatabase.users;
		if(users.containsKey(u.getUsername())) {
			User user = users.get(u.getUsername());
			if(user.getPassword().equals(u.getPassword())) {
				flag = true;
			}
		}
		return flag;
	}
}
