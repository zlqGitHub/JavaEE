package nuc.sw.dangdang.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import nuc.sw.dangdang.db.BookDatabase;
import nuc.sw.dangdang.entity.Book;
import nuc.sw.dangdang.service.BookService;

@SuppressWarnings("serial")
public class BookAction extends ActionSupport implements ModelDriven<Book>{
	private Book b = new Book();
	private List<Book> books;
	

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	private BookService bService = new BookService();
	
	//添加书籍
	public String addBookMethod() {
//		System.out.println(b.getBname());
		bService.insertBook(b);
//		System.out.println(b.getBauthor());
		return "insertOK";
	}

	//获取书籍
	public String getBookMethod(){
		books = BookDatabase.books;
		return "getBookOk";
	}

	@Override
	public Book getModel() {
		// TODO Auto-generated method stub
		return b;
	}

	

}
