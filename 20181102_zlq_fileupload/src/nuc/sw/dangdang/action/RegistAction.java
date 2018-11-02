package nuc.sw.dangdang.action;


import java.io.*;
import java.util.UUID;

import com.opensymphony.xwork2.ActionSupport;

import com.opensymphony.xwork2.ModelDriven;

import nuc.sw.dangdang.entity.Address;
import nuc.sw.dangdang.entity.User;
import nuc.sw.dangdang.service.UserService;

@SuppressWarnings("serial")
public class RegistAction extends ActionSupport  implements ModelDriven<User>{
	private User u = new User();
	private UserService uService = new UserService();
	private Address address = new Address();	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String registMethod() throws IOException {
		System.out.println(u.getUpload());
		System.out.println(u.getUploadFileName());
		System.out.println(u.getUploadContentType());
		
		FileInputStream fis = new FileInputStream(u.getUpload());
		FileOutputStream fos = new FileOutputStream("/D:/JavaEE/file"+"/"+UUID.randomUUID()+u.getUploadFileName());
		
		byte[] buffer = new byte[1024];
		int len=0;
		
		while((len = fis.read(buffer)) > 0) {
			fos.write(buffer,0,len);
		}
		
		fis.close();
		fos.close();
		
		uService.insertUser(u);
		
		return "registOK";
	}
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return u;
	}
	
}
