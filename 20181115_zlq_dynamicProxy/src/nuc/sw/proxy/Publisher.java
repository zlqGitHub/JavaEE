package nuc.sw.proxy;
//真理主题角色:实现接口未实现的方法
public class Publisher implements ISaleBook {
	public void madeBook() {
		System.out.println("出版社造书！");
	}
	

	@Override
	public void saleBook() {
		// TODO Auto-generated method stub
		System.out.println("出版社卖书！");

	}

}
