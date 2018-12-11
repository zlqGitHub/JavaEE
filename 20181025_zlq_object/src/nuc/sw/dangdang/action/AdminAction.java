package nuc.sw.dangdang.action;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AdminAction extends ActionSupport {
	private String admin;
	private String pass;
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String AdminMethod() {
//		System.out.println(admin+pass);
		
		return "AdminLoginOK";
	}
	

}
