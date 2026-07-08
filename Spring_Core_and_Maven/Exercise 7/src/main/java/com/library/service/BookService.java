package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        System.out.println("Constructor injection called.");
        this.bookRepository = bookRepository;
    }

    public void setBookRepository(BookRepository bookRepository) {
        System.out.println("Setter injection called.");
        this.bookRepository = bookRepository;
    }

    public void printServiceInfo() {
        System.out.println("BookService is running.");
        if (bookRepository != null) {
            bookRepository.printRepositoryInfo();
        }
    }
}
