package nuc.sw.dangdang.service;

import java.util.List;

import nuc.sw.dangdang.dao.UserDao;
import nuc.sw.dangdang.entity.Student;

public class UserService {
	UserDao uDao = new UserDao();
	//ע�����һ���û�
	public void insertUser(Student u) {
		uDao.insertUser(u);
	}
	
	//��ȡ�����û�
	public List<Student> listUsers(){
		return uDao.listUsers();
	}

}
