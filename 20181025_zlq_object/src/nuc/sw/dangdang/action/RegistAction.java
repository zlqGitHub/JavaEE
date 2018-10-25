package nuc.sw.dangdang.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import nuc.sw.dangdang.entity.User;

@SuppressWarnings("serial")
public class RegistAction extends ActionSupport implements ModelDriven<User>{
	
	private User user = new User();
	
	public String RegistMethod() {
		return "registOK";
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	

}
