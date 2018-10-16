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
			return "loginOK";
		}else {
			this.addFieldError("error", "用户名或密码错误！");
			return LOGIN;
		}
		
	}
	
	//处理注册
	public String registMethod() {
		uService.insertUser(user);
		ActionContext.getContext().getSession().put("username", user.getUsername());
		info = "注册成功，请重新登录！";
		return "registOK";
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	//只验证注册时的用户名密码
	public void validateRegistMethod() {   
		//trim()函数删除字符串左右的空格
		if(user.getUsername() == null || user.getUsername().trim().equals("")) {
			this.addFieldError("username", "用户名不能为空！");
			
		}
		else if(user.getUsername().length() < 6 || user.getUsername().length() > 16){
			this.addFieldError("username", "输入的用户名不合法，请输入大小为4~16为！");
		}
		
		if(user.getPassword() == null || user.getPassword().trim().equals("")) {
			this.addFieldError("password", "密码不能为空！");
			
		}
	}

	

}
