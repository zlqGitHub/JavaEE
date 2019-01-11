package nuc.ee.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import nuc.ee.model.Admin;
import nuc.ee.service.AdminService;

@SuppressWarnings("serial")
public class AdminLoginAction extends ActionSupport implements ModelDriven<Admin>{
	private Admin ad = new Admin();
	AdminService as = new AdminService();
	List<Admin> adList = new ArrayList<Admin>();
	
	public List<Admin> getAdList() {
		return adList;
	}

	public void setAdList(List<Admin> adList) {
		this.adList = adList;
	}

	public String execute() {
//		System.out.println(ad.getAdmin()+ad.getPass()+ad.getType());
		
		adList = as.get_admin();
		System.out.println(adList);
		
		return "teacher";
	}

	@Override
	public Admin getModel() {
		// TODO Auto-generated method stub
		return ad;
	}

}
