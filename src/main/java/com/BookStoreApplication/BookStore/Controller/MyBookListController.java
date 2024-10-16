package com.BookStoreApplication.BookStore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.BookStoreApplication.BookStore.Service.MyBooksListServiceImpl;

@Controller
public class MyBookListController {
	@Autowired
	private MyBooksListServiceImpl myBooksListServiceImpl;
	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id") int id) {
		myBooksListServiceImpl.deleteById(id);
		return "redirect:/my_Books";
		}

}
