package nuc.sw.dangdang.action;

import com.opensymphony.xwork2.ActionContext;

import com.opensymphony.xwork2.ActionSupport;


@SuppressWarnings("serial")
public class LeaveingAction extends ActionSupport{
	
	public String LeaveingMethod() {  //将保存在session中的用户清空->注销
		//ActionContext.getContext().getSession().remove("user");   //使得session中的user失效
		ActionContext.getContext().getSession().put("username", "");
//		ActionContext.getContext().getSession().clear();
//		System.out.println("a"+ActionContext.getContext().getSession().get("username")+"b");
		return "leaveOK";
	}

}
