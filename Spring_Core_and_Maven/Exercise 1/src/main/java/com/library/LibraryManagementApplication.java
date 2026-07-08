package com.library;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;
import com.library.repository.BookRepository;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        BookRepository bookRepository = context.getBean("bookRepository", BookRepository.class);
        bookService.printServiceInfo();
        bookRepository.printRepositoryInfo();
        context.close();
    }
}
