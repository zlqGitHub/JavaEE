package nuc.sw.dangdang.action;

import com.opensymphony.xwork2.ActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import nuc.sw.dangdang.dao.DataDao;
import nuc.sw.dangdang.entity.MyInfo;

//�޸��ҵĸ�����Ϣ  ����update
@SuppressWarnings("serial")
public class UpdateMyInfoAction extends ActionSupport implements ModelDriven<MyInfo> {

	MyInfo stu = new MyInfo();    //��װ�޸ĸ�����Ϣ���ֵ
	DataDao dao = new DataDao();
	public MyInfo getStu() {
		return stu;
	}

	public void setStu(MyInfo stu) {
		this.stu = stu;
	}
	
	public String UpdateMyInfoMethod() {
		String user = (String) ActionContext.getContext().getSession().get("username");
		String pass = (String) ActionContext.getContext().getSession().get("pass");
		String tel = (String) ActionContext.getContext().getSession().get("tel");
//		System.out.println("pp"+pass+" "+tel+" "+user);	  //session���е�ֵ
//		System.out.println("aa"+stu.getPassword());
//		System.out.println("bb"+stu.getTelphone());
		//���롢�绰δ�޸�
		if(stu.getPassword().equals(pass) && stu.getTelphone().equals(tel)) {  
			dao.updateMyInfo(Integer.parseInt(user), pass, tel);
//			System.out.println(i);
		}
		//����δ�޸ģ��绰�޸�
		else if(stu.getPassword().equals(pass) && !stu.getTelphone().equals(tel)) {
			dao.updateMyInfo(Integer.parseInt(user), pass, stu.getTelphone());
		}
		//�����޸ģ��绰δ�޸�
		else if(!stu.getPassword().equals(pass) && stu.getTelphone().equals(tel)) {
			dao.updateMyInfo(Integer.parseInt(user), stu.getPassword(), tel);
		}
		//���޸�
		else {
			dao.updateMyInfo(Integer.parseInt(user), stu.getPassword(), stu.getTelphone());
		}
		this.addFieldError("error", "�����µ�¼");
		return "updateMyInfoOK";
	}

	@Override
	public MyInfo getModel() {
		// TODO Auto-generated method stub
		return stu;
	}

}


