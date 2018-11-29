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
		// ���յ�¼���ύ����������(struts2�Ĳ����������Ѿ��������)
		//�ж��û�����cxn�����루123���Ƿ�Ϸ�
		if(username.equals("zlq")&&password.equals("000")){
			//�û�������session(Struts2����session�ķ���)
			ActionContext.getContext().getSession().put("user", username);
			ActionContext.getContext().put("success", this.getText("succTip"));
			return SUCCESS;
		}else{
			//������Ϣ�ŵ�request��(Struts2����request��ķ���)
			ActionContext.getContext().put("error", this.getText("failTip"));
			return ERROR;
		}
		
	}
}
