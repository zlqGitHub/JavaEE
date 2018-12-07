package nuc.sw.dangdang.action;

import java.util.*;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import nuc.sw.dangdang.dao.DataDao;
import nuc.sw.dangdang.entity.Book;
import nuc.sw.dangdang.entity.BookNameSelect;

@SuppressWarnings("serial")
public class BookNameSelectAction extends ActionSupport implements ModelDriven<BookNameSelect>{
	
	private BookNameSelect bName = new BookNameSelect();
	DataDao dao = new DataDao();
	
	List<Book> bookList = new ArrayList<Book>();
	
	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public BookNameSelect getbName() {
		return bName;
	}

	public void setbName(BookNameSelect bName) {
		this.bName = bName;
	}
	
	public String BookNameSelectMethod() {
//		System.out.println(bName.getBookName());
		bookList = dao.book_name_select(bName.getBookName());
//		System.out.println("aa"+bookList);
		return "bookNameSelectOK";
	}

	@Override
	public BookNameSelect getModel() {
		// TODO Auto-generated method stub
		return bName;
	}
	
	

}
