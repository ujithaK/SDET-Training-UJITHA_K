package org.example.service;

import org.example.model.Book;
import org.example.model.Member;

public class Main {
    public static void main(String[] args) {

        // Create Librarian (Library Manager)
        Librarian librarian = new Librarian("Admin", "EMP001");

        // Add Books
        Book b1 = new Book("B001", "It Ends With Us", "Tolkien");
        Book b2 = new Book("B002", "MidNight Summer", "James");

        librarian.addBook(b1);
        librarian.addBook(b2);

        // Register Members
        Member m1 = new Member("M01", "UJITHA");
        Member m2 = new Member("M02", "Manasa");

        librarian.registerMember(m1);
        librarian.registerMember(m2);

        // Issue Book
        librarian.issueBook("B001", "M01", "2025-01-01");
        librarian.issueBook("B002","M02","2025-01-03");

        //giving wrong bookid for exception
        librarian.issueBook("333","M01","2025-01-10");

        // Search Book
        librarian.searchBook("It Ends With Us");

        // Return Book
        librarian.returnBook("B002", "M02", "2025-01-30");

        // Show All Transaction Logs
        librarian.showTransactions();
    }
}
