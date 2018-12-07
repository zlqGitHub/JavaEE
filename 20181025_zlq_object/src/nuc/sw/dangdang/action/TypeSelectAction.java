package nuc.sw.dangdang.action;

import java.io.UnsupportedEncodingException;
import java.util.*;

import com.opensymphony.xwork2.ActionSupport;

import nuc.sw.dangdang.dao.DataDao;
import nuc.sw.dangdang.entity.Book;

@SuppressWarnings("serial")
public class TypeSelectAction extends ActionSupport {
	DataDao dao = new DataDao();
	private String type;
	List<Book> bookList = new ArrayList<Book>();
	
	public List<Book> getBookList() {
		return bookList;
	}
	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String TypeSelectMethod() {
		byte[] buf;      //解决传参乱码
		try {
			buf = type.getBytes("ISO8859-1");
			type = new String(buf,"utf-8").replace("\'", "");     //去掉字符串中的单引号
//			System.out.println("type:"+type);
			if(type.equals("全部")) {   
				bookList = dao.books_select();
			}
			else {
				bookList = dao.books_type_select(type);
			}
//			System.out.println("books"+bookList);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "typeSelectOK";
	}
	
}
