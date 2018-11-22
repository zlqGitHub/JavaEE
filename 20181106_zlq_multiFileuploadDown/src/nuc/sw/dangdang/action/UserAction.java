package nuc.sw.dangdang.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import nuc.sw.dangdang.entity.User;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User u = new User();
	
	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}
	
	public String execute() {
		if("zlq".equals(u.getUsername()) && "000".equals(u.getPassword())) {
			ActionContext.getContext().getSession().put("user",u);
			return "loginOK";
		}
		else {
			this.addFieldError("error", "用户名或密码错误！");
			return "error";
		}
		
		
	}


	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return u;
	}

}
