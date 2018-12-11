package nuc.sw.dangdang.action;

import java.util.*;

import nuc.sw.dangdang.dao.DataDao;
import nuc.sw.dangdang.entity.Book;

public class BookAction {
	DataDao dao = new DataDao();
	List<Book> bookLists = new ArrayList<Book>();
	
	public List<Book> getBookLists() {
		return bookLists;
	}

	public void setBookLists(List<Book> bookLists) {
		this.bookLists = bookLists;
	}

	//ªÒ»° ÈºÆ
	public String getBookMethod(){
		bookLists = dao.books_select();
//		System.out.println(bookLists);
		return "getBookOk";
	}

}
