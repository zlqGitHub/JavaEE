package nuc.sw.dangdang.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import nuc.sw.dangdang.dao.DataDao;
import nuc.sw.dangdang.entity.Book;
import nuc.sw.dangdang.entity.MyInfo;

//点击借阅后的处理
@SuppressWarnings("serial")
public class BorrowBookAction extends ActionSupport {
	public int id;
	public String sd;    //存储当前时间
	DataDao dao = new DataDao();
	List<Book> abook = new ArrayList<Book>();
	List<MyInfo> myInfo = new ArrayList<MyInfo>();
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getSd() {
		return sd;
	}

	public void setSd(String sd) {
		this.sd = sd;
	}

	public List<Book> getAbook() {
		return abook;
	}

	public void setAbook(List<Book> abook) {
		this.abook = abook;
	}

	public List<MyInfo> getMyInfo() {
		return myInfo;
	}

	public void setMyInfo(List<MyInfo> myInfo) {
		this.myInfo = myInfo;
	}

	public String BorrowBookMethod() {
//		System.out.println("id:"+id);
		String user = (String) ActionContext.getContext().getSession().get("username");
//		System.out.println("user:"+user);
		int userId = Integer.parseInt(user);
		myInfo = dao.myInfo_select(userId);
		
		long timeStamp = System.currentTimeMillis();   //获取当前时间戳
//		System.out.println(timeStamp);
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sd = date.format(new Date(timeStamp));
//		System.out.println(sd);
//		System.out.println(myInfo);	
		abook = dao.book_id_select(id);
		return "borrowOK";
	}
	

}
