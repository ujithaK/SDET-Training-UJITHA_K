package org.example.util;

import org.example.model.Book;
import org.example.model.Member;
import org.example.service.Library;


public class Main {
    public static void main(String[] args) {

        Library library = new Library();

        // Add Books
        Book b1 = new Book("It ends with us", "Tolkien", "ISBN001");
        Book b2 = new Book("MidNight Summer", "James", "ISBN002");

        library.addBook(b1);
        library.addBook(b2);

        // Register Members
        Member m1 = new Member("UJITHA", "M01");
        Member m2=new Member("manasa","M02");
        library.registerMember(m1);

        // Issue Book
        library.issueBook("ISBN001", "M01", "2025-01-01");

        // Search Book
        library.searchBook("It ends with us");

        // Return Book
        library.returnBook("ISBN001", "M01", "2025-01-30");

        // Show Transaction Log
        library.showTransactions();
    }
}
