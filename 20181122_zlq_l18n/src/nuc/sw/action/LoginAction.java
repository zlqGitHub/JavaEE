package nuc.sw.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport {
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public void validate() {   
		// TODO Auto-generated method stub
		if(username==null||username.trim().equals("")){
			this.addFieldError("usernameError", this.getText("user.required"));
		}
		if(password==null||password.trim().equals("")){
			this.addFieldError("passwordError", this.getText("pass.required"));
		}
		
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		// 接收登录表单提交过来的数据(struts2的参数拦截器已经帮你完成)
		//判断用户名（cxn）密码（123）是否合法
		if(username.equals("zlq")&&password.equals("000")){
			//用户名放入session(Struts2访问session的方法)
			ActionContext.getContext().getSession().put("user", username);
			ActionContext.getContext().getSession().put("english", this.getText("english"));
			ActionContext.getContext().getSession().put("chinese", this.getText("chinese"));
			ActionContext.getContext().put("success", this.getText("succTip"));
			return SUCCESS;
		}else{
			//错误信息放到request域(Struts2访问request域的方法)
			ActionContext.getContext().put("error", this.getText("failTip"));
			return ERROR;
		}
		
	}
}
