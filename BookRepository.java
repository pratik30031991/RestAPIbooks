package com.springboot.restdemo.firstrestdemo.Dao;

import com.springboot.restdemo.firstrestdemo.model.Book;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Integer> {
    
    public Book findById(int id);
}
