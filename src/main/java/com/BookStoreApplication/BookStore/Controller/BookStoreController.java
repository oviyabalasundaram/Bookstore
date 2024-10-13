package com.BookStoreApplication.BookStore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.BookStoreApplication.BookStore.Entity.Book;
import com.BookStoreApplication.BookStore.Service.BookServiceImpl;


@Controller
public class BookStoreController {
	
	@Autowired
	private BookServiceImpl bookServiceImpl;
	
@GetMapping(value ="/home")
public String home() {
	return "Home";
}

@GetMapping(value="/book_register")
public String bookRegister() {
	return "bookRegister";
}

@GetMapping(value="/available_books")
public ModelAndView getAllAvailableBooks() {
	List<Book> list = bookServiceImpl.getAllAvailableBook();
//	ModelAndView m = new ModelAndView();
//	m.setViewName("available books");
//	m.addObject("book",list);
	return new ModelAndView("available_books","book",list);
	
}

@PostMapping(value="/save")
public String addBook(@ModelAttribute Book b) {
	bookServiceImpl.save(b);
	return "redirect:/available_books";
}
	




}
