package nuc.sw.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ShopOnline implements AbstractProxy {
	
	Press p = new Press();
	
	public void preSaleBook() {
		System.out.println("宣传");
	}
	
	public void postSaleBook() {
		System.out.println("售后");
	}
	
	@Override
	public void saleBook() {
		// TODO Auto-generated method stub
		System.out.println("在线卖书");
	}
	public void invoke() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method[] methods = p.getClass().getDeclaredMethods();  //获取Press下的所有方法
		for(Method m : methods) {
			System.out.println(m.getName());
			if("saleBook".equals(m.getName())) {   //如果是卖书，则执行在线卖书方法
				this.preSaleBook();
				m.invoke(p);
				this.postSaleBook();
				
			}
			else {   //非卖书，执行其他方法
				m.invoke(p);
			}
		}
	}
	
	

}
