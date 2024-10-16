package com.BookStoreApplication.BookStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BookStoreApplication.BookStore.Entity.MyBookList;

@Repository
public interface MyBooksRepository extends JpaRepository<MyBookList, Integer>{

}
