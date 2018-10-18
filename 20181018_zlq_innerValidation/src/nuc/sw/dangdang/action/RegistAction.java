package nuc.sw.dangdang.action;


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
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return u;
	}
	
}
