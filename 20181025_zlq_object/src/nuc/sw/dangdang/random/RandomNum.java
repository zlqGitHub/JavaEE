package nuc.sw.dangdang.random;

import java.util.Random;

public class RandomNum{
	public static String random;
	
	public String getRandom() {
		return random;
	}

	public void setRandom(String random) {
		RandomNum.random = random;
	}

	public static void main(String[] args) {
		String str="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
		StringBuilder sb=new StringBuilder(4);
		
		for(int i=0;i<4;i++){
			//public int nextInt(int n) 该方法的作用是生成一个随机的int值，该值介于[0,n)的区间，也就是0到n之间的随机int值，包含0而不包含n。
			char ch=str.charAt(new Random().nextInt(str.length()));
			sb.append(ch);
		}
		
			random = sb.toString();
//			System.out.println(sb.toString());
//			System.out.println(random);
		}
}

