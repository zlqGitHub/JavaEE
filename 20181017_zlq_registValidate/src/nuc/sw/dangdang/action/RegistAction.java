package nuc.sw.dangdang.action;

import java.util.Iterator;

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
	
	public void validateRegistMethod() {
		Iterator<User> users = uService.listUsers().iterator();
		//email地址的验证
		if(!u.getEmail().matches("^[a-zA-Z0-9_.]+@[a-zA-Z0-9_]+\\.[a-zA-Z0-9.]+$")) {
			this.addFieldError("email1", "email格式不正确！");
		}
		//密码的验证
		if(u.getPassword().matches("/^\\w{4,25}$")) {
			this.addFieldError("password1", "密码必须是字母和数字，且长度在4~25之间！");
		}else if(!u.getPassword().equals(u.getPassword2())) {
			this.addFieldError("password1", "两次密码不一致，请重新输入！");
		}
		//昵称的验证
		while(users.hasNext()) {
			if(u.getNickname().equals(users.next().getNickname())) {
				this.addFieldError("nickname1", "该昵称已存在！");
			}
		}
		//真是姓名的验证
		if(u.getUsername() == null || u.getUsername().equals("")) {
			this.addFieldError("username1", "姓名不能为空！");
		}
		//手机号码的验证
		if(!u.getTelphone().matches("1[3578][0134579]\\d{8}")) {
			this.addFieldError("telphone1", "请填写正确的电话号码格式！");
		}
		
	}
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return u;
	}
	
}
