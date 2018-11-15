package nuc.sw.proxy;

import java.lang.reflect.Method;

//代理主题角色
public class ShopOnline implements ISaleBook {
	
	private Publisher publisher = new Publisher();
	
	public void preSaleBook() {   //卖书前
		System.out.println("宣传");
	}
	
	public void postSaleBook() {   //卖书后
		System.out.println("售后");
	}

	@Override
	public void saleBook() {
		// TODO Auto-generated method stub
		/*this.preSaleBook();
		publisher.salebook();
		this.postSaleBook();*/
		this.invoke();
//		System.out.println("在线卖书！");
	}
	
	public void invoke()  {  //反射机制
		Method[] methods = publisher.getClass().getMethods();
		for(Method m:methods) {
			try {
				if("saleBook".equals(m.getName())) {
					this.preSaleBook();
					m.invoke(publisher);
					this.postSaleBook();
				}
				else {
					m.invoke(publisher);
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
		
			
		}
	}

}
