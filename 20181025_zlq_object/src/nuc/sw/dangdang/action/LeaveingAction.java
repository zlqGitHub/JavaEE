package nuc.sw.dangdang.action;

import com.opensymphony.xwork2.ActionContext;

import com.opensymphony.xwork2.ActionSupport;


@SuppressWarnings("serial")
public class LeaveingAction extends ActionSupport{
	
	public String LeaveingMethod() {  //��������session�е��û����->ע��
		//ActionContext.getContext().getSession().remove("user");   //ʹ��session�е�userʧЧ
		ActionContext.getContext().getSession().put("username", "");
//		ActionContext.getContext().getSession().clear();
//		System.out.println("a"+ActionContext.getContext().getSession().get("username")+"b");
		return "leaveOK";
	}

}
