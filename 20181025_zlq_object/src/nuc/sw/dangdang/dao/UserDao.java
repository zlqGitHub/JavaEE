package nuc.sw.dangdang.dao;

import java.util.List;

import nuc.sw.dangdang.db.UserDatabase;
import nuc.sw.dangdang.entity.Student;

public class UserDao {
	//ע��д��һ���û�
	public void insertUser(Student u) {
		UserDatabase.users.add(u);
	}
	
	//��ȡ�����û�
	public List<Student> listUsers(){
		return UserDatabase.users;
	}

}
