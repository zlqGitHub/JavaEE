package nuc.sw.dangdang.action;

import java.util.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import nuc.sw.dangdang.dao.DataDao;
import nuc.sw.dangdang.entity.MyInfo;

//�ҵĸ�����Ϣ��ѯ 
@SuppressWarnings("serial")
public class MyInfoAction extends ActionSupport {
	DataDao dao = new DataDao();
	private String userId;
	List<MyInfo> myInfoList = new ArrayList<MyInfo>();

	public List<MyInfo> getMyInfoList() {
		return myInfoList;
	}

	public void setMyInfoList(List<MyInfo> myInfoList) {
		this.myInfoList = myInfoList;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String MyInfoMethod() {
//		System.out.println(userId);
		userId = userId.replace("\'","" );
//		System.out.println(userId.length());
		int student_no = Integer.parseInt(userId);
//		System.out.println(student_no);
		myInfoList = dao.myInfo_select(student_no);
		//���ѧ�ź����롢�绰�����������Ա��޸�UpdateMyInfoAction
		ActionContext.getContext().getSession().put("pass", myInfoList.iterator().next().getPassword());
		ActionContext.getContext().getSession().put("tel", myInfoList.iterator().next().getTelphone());
//		System.out.println(myInfoList);
		return "myInfoOK";
	}
	

}
