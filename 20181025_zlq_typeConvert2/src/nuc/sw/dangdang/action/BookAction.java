package nuc.sw.dangdang.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import nuc.sw.dangdang.db.BookDatabase;
import nuc.sw.dangdang.entity.Book;
import nuc.sw.dangdang.service.BookService;

@SuppressWarnings("serial")
public class BookAction extends ActionSupport implements ModelDriven<Book>{

	private Book book = new Book();
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

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
		bService.insertBook(book);
//		System.out.println(b.getBauthor());
		return "insertOK";
	}
	
	//删除书籍
	public String deleteBookMethod() {
		System.out.println(book.getBname());
		bService.removeBook(book.getBname());
		books = BookDatabase.books;
		System.out.println(books);
		
		return "deleteOK";
	}
	
	
	//确认修改
	public String confirmUpdataBookMethod() {
		Book book1 = bService.getBook(book.getBname());
		book1.setBname(book.getBname());
		book1.setBauthor(book.getBauthor());
		book1.setBprice(book.getBprice());
		
		return "confirmUpdataOK";
	}
	
	//修改书籍
	public String updataBookMethod() {
		System.out.println(book.getBname());
		System.out.println(book.getBauthor());
		System.out.println(book.getBprice());
		book = bService.getBook(book.getBname());
		System.out.println(book);
		System.out.println(book.getBauthor());
		return "updataOK";
	}

	//获取书籍
	public String getBookMethod(){
		books = BookDatabase.books;
		return "getBookOk";
	}

	@Override
	public Book getModel() {
		// TODO Auto-generated method stub
		return book;
	}

	

}
