package nuc.sw.animal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
//ͨ���˷����ж�ϵͳ�������������ĸ�����
public class ProxyHandler implements InvocationHandler {
	//��Ҫ�����Ŀ�����
	private Object target;
	//����������ʵ��
	DogIntercepter di = new DogIntercepter();
	

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		Object result = null;
		if(method.getName().equals("info")) {
			//��������������A
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
