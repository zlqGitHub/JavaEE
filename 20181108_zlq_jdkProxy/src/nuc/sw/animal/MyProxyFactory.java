package nuc.sw.animal;

import java.lang.reflect.Proxy;
//������
public class MyProxyFactory {
	public static Object getProxy(Object object) {
		//����Ĵ�����
		ProxyHandler handler = new ProxyHandler();
		//��ʵ���и����������
		handler.setTarget(object);
		//��һ����������������̬�����ClassLoader����ֻҪ�ö����ܷ���Dog�ӿڼ���
		//�ڶ��������ǽӿ����飬���Ǵ���ýӿ�����
		//�����������Ǵ�������Ĵ���ʵ��
		return Proxy.newProxyInstance(DogImpl.class.getClassLoader(), object.getClass().getInterfaces(), handler);
		
	}

}
