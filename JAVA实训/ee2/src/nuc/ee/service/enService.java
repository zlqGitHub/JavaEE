package nuc.ee.service;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

import nuc.ee.dao.enDao;
import nuc.ee.model.*;
public class enService {
	enDao dao = new enDao();
	public List<En> inIt(String en) {			//��ѯ
		List<En> enalist= dao.inIt(en);
		return enalist;
	}
	public int DeleteEn(String en ,String td){		//ɾ��
		int age = dao.DeleteEn(en,td);
		return age;
	}	
	public int addEn(String en ,String td,String state) {		//���
		int age = dao.addEn(en,td, state);
		return age;
	}
	public int update(String en ,String td, String state) {	//�޸�	
		int age = dao.updateEn(en,td, state);
		return age;
	}
}
