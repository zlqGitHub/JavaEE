package nuc.sw.dangdang.intercepter;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


@SuppressWarnings("serial")
public class LoginedIntercepetor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		ActionContext ac = arg0.getInvocationContext();
		String username = (String)ac.getSession().get("username");
		System.out.println("aa"+username);
		int len = username.length();  
//		System.out.println(len);  
		if(len != 0){    //用长度来判断是否需要登录
			System.out.println("bushikong");
			return arg0.invoke();   //放行，访问完回来执行下面 代码
		} else {
			((ActionSupport)arg0.getAction()).addFieldError("error", "请先登录");
			return Action.LOGIN;
		}
	
	}

}
