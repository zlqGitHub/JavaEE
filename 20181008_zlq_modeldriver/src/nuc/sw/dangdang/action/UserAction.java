package nuc.sw.dangdang.action;    

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import nuc.sw.dangdang.entity.User;

//ģ����������
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
		if("����ǿ".equals(user.getUsername()) && "000".equals(user.getPassword())) {
			ActionContext.getContext().getSession().put("username", user.getUsername());
			return SUCCESS;
		}
		else {
			this.addFieldError("error", "�û������������");
			return ERROR;
		}
		
	}


	

}
