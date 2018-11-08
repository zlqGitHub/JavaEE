package nuc.sw.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ShopOnline implements AbstractProxy {
	
	Press p = new Press();
	
	public void preSaleBook() {
		System.out.println("����");
	}
	
	public void postSaleBook() {
		System.out.println("�ۺ�");
	}
	
	@Override
	public void saleBook() {
		// TODO Auto-generated method stub
		System.out.println("��������");
	}
	public void invoke() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method[] methods = p.getClass().getDeclaredMethods();  //��ȡPress�µ����з���
		for(Method m : methods) {
			System.out.println(m.getName());
			if("saleBook".equals(m.getName())) {   //��������飬��ִ���������鷽��
				this.preSaleBook();
				m.invoke(p);
				this.postSaleBook();
				
			}
			else {   //�����飬ִ����������
				m.invoke(p);
			}
		}
	}
	
	

}
