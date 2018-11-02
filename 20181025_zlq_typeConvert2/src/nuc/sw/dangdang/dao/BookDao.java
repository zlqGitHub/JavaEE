package nuc.sw.dangdang.dao;

import nuc.sw.dangdang.entity.Book;

import java.util.*;

import nuc.sw.dangdang.db.BookDatabase;

public class BookDao {
	
	//���һ���鼮
	public void insertBook(Book b){
		BookDatabase.books.add(b);
	}
	
	//ɾ���鼮
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
	
	//�޸��鼮
	public void updataBook(String s) {
		BookDao bDao = new BookDao();
		bDao.getBook(s);
		
		
	}
	
	//��ȡһ���鼮�ļ�¼
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
	
	//��ȡ�����鼮
	public List<Book> listBooks(){
		return BookDatabase.books;
	}

}
