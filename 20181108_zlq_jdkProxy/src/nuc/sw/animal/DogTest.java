package nuc.sw.animal;

public class DogTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建Dog实例，作为代理的目标对象
		Dog targetObject = new DogImpl();
		Dog dog = null;
		//以目标对象创建代理
		Object proxy = MyProxyFactory.getProxy(targetObject);
		if(proxy instanceof Dog) {
			dog = (Dog)proxy;
		}
		//测试方法
		dog.run();
		dog.info();
	}

}
