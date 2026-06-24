package com.demo;

import java.util.Arrays;
import java.util.Comparator;

public class LibraryManagementSystem {

    static class Book {
        private int bookId;
        private String title;
        private String author;

        public Book(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "bookId=" + bookId +
                    ", title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    '}';
        }
    }

    public static Book linearSearch(Book[] books, String targetTitle) {

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(targetTitle)) {
                return book;
            }
        }

        return null;
    }

    public static Book binarySearch(Book[] books, String targetTitle) {

        int left = 0;
        int right = books.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int comparison =
                    books[mid].getTitle().compareToIgnoreCase(targetTitle);

            if (comparison == 0) {
                return books[mid];
            }

            if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Book[] books = {
                new Book(101, "Java Programming", "James Gosling"),
                new Book(102, "Data Structures", "Mark Allen"),
                new Book(103, "Algorithms", "Robert Sedgewick"),
                new Book(104, "Operating Systems", "Andrew Tanenbaum"),
                new Book(105, "Computer Networks", "Behrouz Forouzan")
        };

        System.out.println("Linear Search Result:");
        System.out.println(
                linearSearch(books, "Algorithms")
        );

        Arrays.sort(
                books,
                Comparator.comparing(Book::getTitle)
        );

        System.out.println("\nBinary Search Result:");
        System.out.println(
                binarySearch(books, "Algorithms")
        );
    }
}