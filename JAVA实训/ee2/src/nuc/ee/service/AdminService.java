package nuc.ee.service;

import java.util.ArrayList;
import java.util.List;

import nuc.ee.dao.AdminDao;
import nuc.ee.model.Admin;

public class AdminService {
	AdminDao ad = new AdminDao();
	List<Admin> adList = new ArrayList<Admin>();
	
	public List<Admin> get_admin() {
		adList = ad.select_admin();
		return adList;
	}
	

}
