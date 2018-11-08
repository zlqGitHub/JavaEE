package nuc.sw.animal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
//通过此方法判定系统调用拦截器的哪个方法
public class ProxyHandler implements InvocationHandler {
	//需要代理的目标对象
	private Object target;
	//创建拦截器实例
	DogIntercepter di = new DogIntercepter();
	

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		Object result = null;
		if(method.getName().equals("info")) {
			//调用拦截器方法A
			di.method1();
			result = method.invoke(target, args);
			di.method2();
		}
		else{
			result = method.invoke(target, args);
		}
		return result;
	}
	
	public void setTarget(Object o) {
		this.target = o;
	}

}
