package com.springboot.restdemo.firstrestdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

    @Id
    private int id;

    @Column
    private String title;

    @Column
    private String auther;

    public Book(int id, String title, String auther) {
        this.id = id;
        this.title = title;
        this.auther = auther;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    @Override
    public String toString() {
        return "Book [auther=" + auther + ", id=" + id + ", title=" + title + "]";
    }


    

    
}
