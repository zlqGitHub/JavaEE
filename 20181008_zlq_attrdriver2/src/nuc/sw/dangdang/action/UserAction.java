package nuc.sw.dangdang.action;    

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import nuc.sw.dangdang.entity.User;

//模型驱动
@SuppressWarnings("serial")
public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User user = new User();

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	public String loginMethod() {
		if("张利强".equals(user.getUsername()) && "000".equals(user.getPassword())) {
			ActionContext.getContext().getSession().put("username", user.getUsername());
			return SUCCESS;
		}
		else {
			this.addFieldError("error", "用户名或密码错误！");
			return ERROR;
		}
		
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	

}
