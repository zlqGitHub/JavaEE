package nuc.sw.dangdang.service;

import java.util.List;

import nuc.sw.dangdang.dao.UserDao;
import nuc.sw.dangdang.entity.User;

public class UserService {
	UserDao uDao = new UserDao();
	//д��һ���û�
	public void insertUser(User u) {
		uDao.insertUser(u);
	}
	//��ȡ�����û�
	public List<User> listUsers(){
		return uDao.listUsers();
	}
	
}
