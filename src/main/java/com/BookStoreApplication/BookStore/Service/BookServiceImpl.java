package com.BookStoreApplication.BookStore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookStoreApplication.BookStore.Entity.Book;
import com.BookStoreApplication.BookStore.Repository.BookRepository;

@Service
public class BookServiceImpl {
	
	@Autowired
	private BookRepository bookRepository;
	
	public void save(Book b) {
		bookRepository.save(b);
		
	}
	public List<Book> getAllAvailableBook(){
		
		return bookRepository.findAll() ;
	}

}
