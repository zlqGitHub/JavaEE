package nuc.sw.animal;

import java.lang.reflect.Proxy;
//代理工厂
public class MyProxyFactory {
	public static Object getProxy(Object object) {
		//代理的处理类
		ProxyHandler handler = new ProxyHandler();
		//把实例托付给代理操作
		handler.setTarget(object);
		//第一个参数用来创建动态代理的ClassLoader对象，只要该对象能访问Dog接口即可
		//第二个参数是接口数组，正是代理该接口数组
		//第三个参数是代理包含的处理实例
		return Proxy.newProxyInstance(DogImpl.class.getClassLoader(), object.getClass().getInterfaces(), handler);
		
	}

}
