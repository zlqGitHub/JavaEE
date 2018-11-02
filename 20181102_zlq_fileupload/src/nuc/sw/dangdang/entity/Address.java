package nuc.sw.dangdang.entity;

public class Address {
	private String province;
	private String city;
	private String area;
	private String street;
	
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	@Override
	public String toString() {
		return "Address [province=" + province + ", city=" + city + ", area=" + area + ", street=" + street + "]";
	}
	
	//全参构造方法
	public Address(String province, String city, String area, String street) {
		// TODO Auto-generated constructor stub
		super();
		this.province = province;
		this.city = city;
		this.area = area;
		this.street = street;
	}
	
	//无参构造方法
	public Address() {
		
	}
	
}











