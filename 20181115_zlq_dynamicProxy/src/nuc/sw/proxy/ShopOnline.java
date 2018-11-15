package nuc.sw.proxy;

import java.lang.reflect.Method;

//���������ɫ
public class ShopOnline implements ISaleBook {
	
	private Publisher publisher = new Publisher();
	
	public void preSaleBook() {   //����ǰ
		System.out.println("����");
	}
	
	public void postSaleBook() {   //�����
		System.out.println("�ۺ�");
	}

	@Override
	public void saleBook() {
		// TODO Auto-generated method stub
		/*this.preSaleBook();
		publisher.salebook();
		this.postSaleBook();*/
		this.invoke();
//		System.out.println("�������飡");
	}
	
	public void invoke()  {  //�������
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
