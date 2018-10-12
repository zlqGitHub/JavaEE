package nuc.sw.dangdang.action;    

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import nuc.sw.dangdang.entity.User;

//模型属性驱动
@SuppressWarnings("serial")
public class UserAction extends ActionSupport{
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

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


	

}
