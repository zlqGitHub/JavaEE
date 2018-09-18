package com.test.db;

import java.util.*;

import com.test.book.Book;

public class BookDao {
	public void insertBook(Book b){
		BookDatabase.books.add(b);
	}
	public List<Book> listBooks(){
		return BookDatabase.books;
	}
	

}
