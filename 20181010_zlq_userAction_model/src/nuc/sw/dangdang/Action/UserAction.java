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
	
	//处理登录
	public String loginMethod() {
		if(uService.isValidUser(user)) {
			ActionContext.getContext().getSession().put("username", user.getUsername());
			return SUCCESS;
		}else {
			this.addFieldError("error", "用户名或密码错误！");
			return LOGIN;
		}
		
	}
	
	//处理注册
	public String registMethod() {
		uService.insertUser(user);
		info = "注册成功，请重新登录！"
				+ "";
		return "registOK";
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	

}
