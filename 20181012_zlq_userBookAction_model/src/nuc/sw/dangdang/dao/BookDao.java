package nuc.sw.dangdang.dao;

import nuc.sw.dangdang.entity.Book;

import java.util.*;

import nuc.sw.dangdang.db.BookDatabase;

public class BookDao {
	//���һ���鼮
	public void insertBook(Book b){
		BookDatabase.books.add(b);
	}
	
	//��ȡ�����鼮
	public List<Book> listBooks(){
		return BookDatabase.books;
	}

}
