package com.springboot.restdemo.firstrestdemo.controller;

import java.util.List;

import com.springboot.restdemo.firstrestdemo.model.Book;
import com.springboot.restdemo.firstrestdemo.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getBooks(){

        return bookService.getAllBooks();
        
    }
    
    @GetMapping("/books/{id}")
    public Book getSingleBook(@PathVariable("id") int id){

        return bookService.getBookById(id); //here wtever id will use pass tru url..
                                            //will gv output of that book with dt perticular id

   }

   @PostMapping("/books")
   public Book addNewBook(@RequestBody Book bo){  // this book obj will come tru req sent by use

    bookService.addBook(bo);               //which is added into our list by 1 of the service method

    return bo;

   }

   @DeleteMapping("/books/{id}")
   public void deleteThisBook(@PathVariable("id") int id){

    bookService.deleteBook(id);

   }

   @PutMapping("/books/{id}")
   public Book updateThisBook(@RequestBody Book bo, @PathVariable("id") int id){
                            //here we get Json data and book id frm the user tru respective anno.
            bookService.updateBook(bo, id);  //bo is the new data frm which we hv to update
                                            //id is the book which is to update
            return bo;
   }

}
