package nuc.sw.dangdang.dao;

import nuc.sw.dangdang.entity.Book;

import java.util.*;

import nuc.sw.dangdang.db.BookDatabase;

public class BookDao {
	
	//添加一本书籍
	public void insertBook(Book b){
		BookDatabase.books.add(b);
	}
	
	//删除书籍
	public void removeBook(String s) {
		Iterator<Book> it = BookDatabase.books.iterator();
		while(it.hasNext()){
		    Book x = it.next();
		    System.out.println("bb");
//		    System.out.println(x.getBname());
		    if(x.getBname().equals(s)){
		    	System.out.println("aa");
		        it.remove();
		    }
		}
	}
	
	//修改书籍
	public void updataBook(String s) {
		BookDao bDao = new BookDao();
		bDao.getBook(s);
		
		
	}
	
	//获取一条书籍的记录
	public Book getBook(String s) {
		
		Iterator<Book> it = BookDatabase.books.iterator();
		Book book = new Book();
		while(it.hasNext()) {
			Book x = it.next();
			if(x.getBname().equals(s)) {
				book = x;
			}
		}
		return book;
		
	}
	
	//获取所有书籍
	public List<Book> listBooks(){
		return BookDatabase.books;
	}

}
