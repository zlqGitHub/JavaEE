package nuc.sw.dangdang.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import nuc.sw.dangdang.entity.User;

@SuppressWarnings("serial")
public class LoginInterceptor extends AbstractInterceptor{
	
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		//�õ�ActionContext��ʵ��
		ActionContext ac = arg0.getInvocationContext();
		User user = (User)ac.getSession().get("user");
		System.out.println(user);
		if(user != null){
			@SuppressWarnings("unused")
			Object currentUser = arg0.getInvocationContext().getSession().get("FileItem");
			return arg0.invoke();   //���У����������ִ������ ����
		} else {
			((ActionSupport)arg0.getAction()).addFieldError("error", "���ȵ�¼");
			return Action.LOGIN;
		}
	
	}
}
