package com.BookStoreApplication.BookStore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookStoreApplication.BookStore.Entity.MyBookList;
import com.BookStoreApplication.BookStore.Repository.MyBooksRepository;

@Service
public class MyBooksListServiceImpl {
	@Autowired
	private MyBooksRepository myBooksRepository;
	public void saveMyBooks(MyBookList bl) {
		myBooksRepository.save(bl);
	}
	public  List<MyBookList> getAllMyBook(){
		return myBooksRepository.findAll();
	}
    public void deleteById(int id) {
    	myBooksRepository.deleteById(id);}
}
