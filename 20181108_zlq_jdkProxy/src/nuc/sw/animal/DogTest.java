package nuc.sw.animal;

public class DogTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����Dogʵ������Ϊ�����Ŀ�����
		Dog targetObject = new DogImpl();
		Dog dog = null;
		//��Ŀ����󴴽�����
		Object proxy = MyProxyFactory.getProxy(targetObject);
		if(proxy instanceof Dog) {
			dog = (Dog)proxy;
		}
		//���Է���
		dog.run();
		dog.info();
	}

}
