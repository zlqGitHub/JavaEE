package nuc.sw.dangdang.entity;

import java.util.Map;


import org.apache.struts2.util.StrutsTypeConverter;

public class AddressConvertor extends StrutsTypeConverter {

	@SuppressWarnings("rawtypes")
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		// TODO Auto-generated method stub
		Address addr = new Address(arg1[0],arg1[1],arg1[2],arg1[3]);
		return addr;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String convertToString(Map arg0, Object arg1) {
		// TODO Auto-generated method stub
		Address addr = (Address)arg1;
		return addr.getProvince() + "ʡ" + addr.getCity() + "��" + addr.getArea() + "��" + addr.getStreet();
	}

}
