package com.library;

import com.library.Repository.BookRepository;
import com.library.Service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookRepository repository =  context.getBean("bookRepository", BookRepository.class);

        BookService service =  context.getBean("bookService", BookService.class);

        repository.display();
        service.display();
    }
}