package org.example.model;

import java.util.HashMap;

public class Member {
    private String name;
    private String memberId;
    private HashMap<String, String> borrowedBooks; // isbn : issueDate (yyyy-mm-dd)

    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = new HashMap<>();
    }

    public String getName() { return name; }
    public String getMemberId() { return memberId; }

    public void borrowBook(String isbn, String issueDate) {
        borrowedBooks.put(isbn, issueDate);
    }

    public String returnBook(String isbn) {
        return borrowedBooks.remove(isbn);
    }

    public HashMap<String, String> getBorrowedBooks() {
        return borrowedBooks;
    }
}

