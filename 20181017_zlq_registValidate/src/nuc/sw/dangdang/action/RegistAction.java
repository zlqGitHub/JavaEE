package nuc.sw.dangdang.action;

import java.util.Iterator;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import nuc.sw.dangdang.entity.User;
import nuc.sw.dangdang.service.UserService;

@SuppressWarnings("serial")
public class RegistAction extends ActionSupport  implements ModelDriven<User>{
	private User u = new User();
	private UserService uService = new UserService();
	
	public String registMethod() {
		uService.insertUser(u);
		return "registOK";
	}
	
	public void validateRegistMethod() {
		Iterator<User> users = uService.listUsers().iterator();
		//email��ַ����֤
		if(!u.getEmail().matches("^[a-zA-Z0-9_.]+@[a-zA-Z0-9_]+\\.[a-zA-Z0-9.]+$")) {
			this.addFieldError("email1", "email��ʽ����ȷ��");
		}
		//�������֤
		if(u.getPassword().matches("/^\\w{4,25}$")) {
			this.addFieldError("password1", "�����������ĸ�����֣��ҳ�����4~25֮�䣡");
		}else if(!u.getPassword().equals(u.getPassword2())) {
			this.addFieldError("password1", "�������벻һ�£����������룡");
		}
		//�ǳƵ���֤
		while(users.hasNext()) {
			if(u.getNickname().equals(users.next().getNickname())) {
				this.addFieldError("nickname1", "���ǳ��Ѵ��ڣ�");
			}
		}
		//������������֤
		if(u.getUsername() == null || u.getUsername().equals("")) {
			this.addFieldError("username1", "��������Ϊ�գ�");
		}
		//�ֻ��������֤
		if(!u.getTelphone().matches("1[3578][0134579]\\d{8}")) {
			this.addFieldError("telphone1", "����д��ȷ�ĵ绰�����ʽ��");
		}
		
	}
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return u;
	}
	
}
