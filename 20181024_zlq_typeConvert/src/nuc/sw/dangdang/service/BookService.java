package nuc.sw.dangdang.service;

import java.util.List;

import nuc.sw.dangdang.dao.BookDao;
import nuc.sw.dangdang.entity.Book;

public class BookService {
	
	private BookDao bDao = new BookDao();
	
	//����鼮
	public void insertBook(Book b) {
		bDao.insertBook(b);
	}
	
	//��ȡ�����鼮
	public List<Book> listBooks(){
		return bDao.listBooks();
	}
	
	

}
