package nuc.ee.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import nuc.ee.model.GignUp;
import nuc.ee.service.UserService;

@SuppressWarnings("serial")
public class GignUpAction2 extends ActionSupport implements ModelDriven<GignUp>{
	GignUp gu = new GignUp();
	UserService us = new UserService();
	public String date;

	public String execute() {
		int num = (int) ActionContext.getContext().getSession().get("num");
		System.out.println("num="+num);
//		System.out.println("userid="+gu.getUserid());
//		System.out.println("username="+gu.getUsername());
//		System.out.println("td="+gu.getTd());
		num--;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//�������ڸ�ʽ
		date = df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
		
		gu.setChange(num);
		us.insert_user(gu,num,"2019-1-13");
		
		return "success";
	}
		
	@Override
	public GignUp getModel() {
		// TODO Auto-generated method stub
		return gu;
	}

}
