package nuc.sw.dangdang.dao;

import nuc.sw.dangdang.entity.Book;

import java.util.*;

import nuc.sw.dangdang.db.BookDatabase;

public class BookDao {
	//添加一本书籍
	public void insertBook(Book b){
		BookDatabase.books.add(b);
	}
	
	//获取所有书籍
	public List<Book> listBooks(){
		return BookDatabase.books;
	}

}
