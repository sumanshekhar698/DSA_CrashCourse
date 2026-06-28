package com.etechniketan.lld.library_management_simple;

import java.util.HashMap;


public class Library {
    // HashMap to store ISBN as Key and Book object as Value
    private HashMap<String, Book> bookMap = new HashMap<>();
    private int totalBooksCount = 0;

    // Method to add a book to the system
    public void addBook(Book book) {
        bookMap.put(book.getIsbn(), book);
        if (book.isAvailable()) {
            totalBooksCount++;
        }
    }

    // The logic requested in the question
    public void borrowBook(String isbn) throws BookNotFoundException {
        // 1. Check if ISBN exists
        if (!bookMap.containsKey(isbn)) {
            throw new BookNotFoundException("Error: Book with ISBN " + isbn + " not found.");
        }

        Book book = bookMap.get(isbn);

        // 2. Check if a book is already borrowed
        if (!book.isAvailable()) {
            throw new IllegalStateException("Error: The book '" + book.getTitle() + "' is already borrowed.");
        }

        // 3. Update status and decrement count
        book.setAvailable(false);
        totalBooksCount--;

        System.out.println("Success! You borrowed: " + book.getTitle());
        System.out.println("Available books remaining: " + totalBooksCount);
    }

    public int getTotalBooksCount() {
        return totalBooksCount;
    }
}