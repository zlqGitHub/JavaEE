package nuc.sw.dangdang.action;

import java.util.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import nuc.sw.dangdang.dao.DataDao;
import nuc.sw.dangdang.entity.Book;
import nuc.sw.dangdang.entity.MyInfo;
import nuc.sw.dangdang.entity.User;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport implements ModelDriven<User>{
	private User user = new User();
	
	List<MyInfo> list = new ArrayList<MyInfo>();
	List<Book> bookList = new ArrayList<Book>();
	
	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public List<MyInfo> getList() {
		return list;
	}

	public void setList(List<MyInfo> list) {
		this.list = list;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	DataDao dao = new DataDao();
	public String LoginMethod() {
//		System.out.println("aa"+ActionContext.getContext().getSession().get("username").toString().length());
		int i = dao.login_select(user);
		if(i == 1) {
			bookList = dao.books_select();
			list = dao.myInfo_select(Integer.parseInt(user.getStudent_no()));
//			System.out.println(list);
//			ActionContext.getContext().getSession().put("list", list);
			ActionContext.getContext().getSession().put("username", user.getStudent_no());
			return "loginOK";
		}
		else {
			this.addFieldError("error", "用户名或密码错误");
			return "loginFail";
		}
	}
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
}
