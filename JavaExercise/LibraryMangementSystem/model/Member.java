package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String memberId;
    private String name;
    private List<Book> issuedBooks;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.issuedBooks = new ArrayList<>();
    }

    // Getters & Setters
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getIssuedBooks() {
        return issuedBooks;
    }

    // Business Methods
    public void issueBook(Book book) {
        issuedBooks.add(book);
        book.markUnavailable();
    }

    public void returnBook(Book book) {
        issuedBooks.remove(book);
        book.markAvailable();
    }
}


