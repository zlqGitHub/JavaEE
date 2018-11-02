package nuc.sw.dangdang.entity;

public class User2 {
	private String emails;
	private String pass;
	public String getEmails() {
		return emails;
	}
	public void setEmails(String emails) {
		this.emails = emails;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "User2 [emails=" + emails + ", pass=" + pass + "]";
	}
	

}
