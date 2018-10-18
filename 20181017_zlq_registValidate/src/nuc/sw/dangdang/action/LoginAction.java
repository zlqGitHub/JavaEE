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
	
	public String loginMethod() {
		return "loginOK";
	}
	
	public void validate() {
		System.out.println(u.getEmails());
		Iterator<User> users = uService.listUsers().iterator();
		while(users.hasNext()) {
			User user = users.next();
			System.out.println(u.getEmails());
//			System.out.println(users.next().getEmail());
			if(u.getEmails().equals(user.getEmail()) && u.getPass().equals(user.getPassword())) {
				return;
			}else {
				this.addFieldError("error", "用户名或密码错误！");
			}
			
		}
		if(!users.hasNext()) {
			this.addFieldError("error", "用户名或密码错误！");
		}
	}
	@Override
	public User2 getModel() {
		// TODO Auto-generated method stub
		return u;
	}

}
