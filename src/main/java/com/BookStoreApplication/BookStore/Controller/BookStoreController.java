package com.BookStoreApplication.BookStore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.BookStoreApplication.BookStore.Entity.Book;
import com.BookStoreApplication.BookStore.Entity.MyBookList;
import com.BookStoreApplication.BookStore.Service.BookServiceImpl;
import com.BookStoreApplication.BookStore.Service.MyBooksListServiceImpl;


@Controller
public class BookStoreController {
	
	@Autowired
	private BookServiceImpl bookServiceImpl;
	
	@Autowired
	private MyBooksListServiceImpl myBooksListServiceImpl;
	
@GetMapping(value ="/home")
public String home() {
	return "home";
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
	return new ModelAndView("availableBooks","book",list);
	
}

@PostMapping(value="/save")
public String addBook(@ModelAttribute Book b) {
	bookServiceImpl.save(b);
	return "redirect:/available_books";
}

@GetMapping(value="/my_Books")
public String getMyBooks(Model model) {
	List<MyBookList> list = myBooksListServiceImpl.getAllMyBook();
	model.addAttribute("book", list);
	return "myBooks";
}

@RequestMapping(value="/myList/{id}")
public String getMyList(@PathVariable("id") int id) {
	Book b = bookServiceImpl.getBookById(id);
	MyBookList mb = new  MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
	myBooksListServiceImpl.saveMyBooks(mb);
	return "redirect:/my_Books";
}

@RequestMapping(value="/editBook/{id}")
public String editBook(@PathVariable("id") int id, Model model){
	Book b=bookServiceImpl.getBookById(id);
	model.addAttribute("book", b);
	return "bookedit";
}
@RequestMapping(value="/deleteBook/{id}")
public String deleteBook(@PathVariable("id") int id) {
	bookServiceImpl.deleteById(id);
			return "redirect:/available_books";
}

	




}
