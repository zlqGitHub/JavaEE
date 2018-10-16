package nuc.sw.dangdang.Action;

import com.opensymphony.xwork2.ActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import nuc.sw.dangdang.entity.User;
import nuc.sw.dangdang.service.UserService;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	private User user = new User();
	private UserService uService = new UserService();
	private String info;

//	public UserService getuService() {
//		return uService;
//	}
//
//	public void setuService(UserService uService) {
//		this.uService = uService;
//	}
	
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	//�����¼
	public String loginMethod() {
		if(uService.isValidUser(user)) {
			ActionContext.getContext().getSession().put("username", user.getUsername());
			return "loginOK";
		}else {
			this.addFieldError("error", "�û������������");
			return LOGIN;
		}
		
	}
	
	//����ע��
	public String registMethod() {
		uService.insertUser(user);
		ActionContext.getContext().getSession().put("username", user.getUsername());
		info = "ע��ɹ��������µ�¼��";
		return "registOK";
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	//ֻ��֤ע��ʱ���û�������
	public void validateRegistMethod() {   
		//trim()����ɾ���ַ������ҵĿո�
		if(user.getUsername() == null || user.getUsername().trim().equals("")) {
			this.addFieldError("username", "�û�������Ϊ�գ�");
			
		}
		else if(user.getUsername().length() < 6 || user.getUsername().length() > 16){
			this.addFieldError("username", "������û������Ϸ����������СΪ4~16Ϊ��");
		}
		
		if(user.getPassword() == null || user.getPassword().trim().equals("")) {
			this.addFieldError("password", "���벻��Ϊ�գ�");
			
		}
	}

	

}
