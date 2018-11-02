package nuc.sw.dangdang.action;

import java.util.Iterator;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import nuc.sw.dangdang.entity.User;
import nuc.sw.dangdang.entity.User2;
import nuc.sw.dangdang.service.UserService;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport implements ModelDriven<User2>{
	private UserService uService = new UserService();
	private User2 u = new User2();
	private String email;
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String loginMethod() {
		email = u.getEmails();
		return "loginOK";
	}
	
	public void validate() {
		Iterator<User> users = uService.listUsers().iterator();
		while(users.hasNext()) {
			User user = users.next();
			if(u.getEmails().equals(user.getEmail()) && u.getPass().equals(user.getPassword())) {
				return;
			}else {
				this.addFieldError("error", "�û������������");
			}
			
		}
		if(!users.hasNext()) {
			this.addFieldError("error", "�û������������");
		}
	}
	@Override
	public User2 getModel() {
		// TODO Auto-generated method stub
		return u;
	}

}
