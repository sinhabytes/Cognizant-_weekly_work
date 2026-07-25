package com.library.Service;

import com.library.Repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public BookService() {
        System.out.println("BookService Bean Created");
    }

    public void setBookRepository(BookRepository bookRepository) {
        System.out.println("BookRepository Injected into BookService");
        this.bookRepository = bookRepository;
    }

    public void display() {
        System.out.println("Book Service is working.");
        bookRepository.display();
    }
}