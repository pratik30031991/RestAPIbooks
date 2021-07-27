package com.springboot.restdemo.firstrestdemo.service;

import java.util.List;

import com.springboot.restdemo.firstrestdemo.Dao.BookRepository;
import com.springboot.restdemo.firstrestdemo.model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class BookService {
    
     

    /* private static List<Book> blist = new ArrayList<>();
    static{

        blist.add(new Book(222,"Telusko", "abc"));
        blist.add(new Book(444,"Code with durgesh", "babu"));
        blist.add(new Book(777,"Java Brains", "cucu"));
    }
 */
        @Autowired
        private BookRepository bookRepository;



    //to retur all books
    public List<Book> getAllBooks(){

        List<Book> blist = (List<Book>)this.bookRepository.findAll();
        return blist ;
    }

    //to return single book
    public Book getBookById(int id){

        //Book book = blist.stream().filter(e->e.getId()==id).findFirst().get();
        Book book = this.bookRepository.findById(id);

        return book;
    }
    
    //to add new book
    public void addBook(Book bo){

        this.bookRepository.save(bo);
        
    }

    //to delete a book
    public void deleteBook(int bid){

        //blist= blist.stream().filter(e->e.getId()!= bid).collect(Collectors.toList());
        //this will ignor the bid book and collect all other books frm the blist 
        //and create a new blist

        this.bookRepository.deleteById(bid);


    }

    //to update a book
    public void updateBook(Book bo ,int bid){

        // blist=blist.stream().map(e->{
        //     if(e.getId()==bid){
        //         e.setTitle(bo.getTitle());
        //         e.setAuther(bo.getAuther());
        //     }
        //     return e;    //basically it will return all books 1 by 1 
                            //but if bid and id match it will go in if loop and get updated 
        // }).collect(Collectors.toList());

            bo.setId(bid);
            bookRepository.save(bo);


    }

}
