package com.etechniketan.lld.library_management_simple;

public class Main {
    public static void main(String[] args) {
        Library myLibrary = new Library();





        // Adding sample books
        myLibrary.addBook(new Book("101", "Java Programming"));
        myLibrary.addBook(new Book("102", "Data Structures"));

        try {
            System.out.println("Initial Count: " + myLibrary.getTotalBooksCount());

            // Test 1: Successful Borrow
            myLibrary.borrowBook("101");

            // Test 2: Borrowing same book again (Should throw IllegalStateException)
             myLibrary.borrowBook("101");

            // Test 3: Borrowing non-existent ISBN (Should throw BookNotFoundException)
             myLibrary.borrowBook("999");

        } catch (BookNotFoundException | IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}