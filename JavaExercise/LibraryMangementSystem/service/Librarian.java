package org.example.service;

import org.example.model.Book;
import org.example.model.Member;
import org.example.model.Transaction;
import org.example.exceptions.BookNotFoundException;
import org.example.exceptions.MemberNotFoundException;

import java.util.HashMap;

public class Librarian {

    private String name;
    private String employeeId;

    private HashMap<String, Book> books = new HashMap<>();
    private HashMap<String, Member> members = new HashMap<>();
    private Transaction transaction = new Transaction();

    public Librarian(String name, String employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    // getters
    public String getName() {
        return name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    // ADD

    public void addBook(Book book) {
        books.put(book.getBookId(), book);
        System.out.println(book.getTitle() + " added to library.");
    }

    // REMOVE BOOK
    public void removeBook(String bookId) {
        if (!books.containsKey(bookId)) {
            throw new BookNotFoundException("Book with ID " + bookId + " not found!");
        }

        System.out.println(books.get(bookId).getTitle() + " removed.");
        books.remove(bookId);
    }

    // MEMBER REGISTRATION

    public void registerMember(Member member) {
        members.put(member.getMemberId(), member);
        System.out.println(member.getName() + " registered successfully.");
    }

    //ISSUE BOOK

    public void issueBook(String bookId, String memberId, String issueDate) {
        Book book = books.get(bookId);  //it will return Book
        if (book == null) {
            throw new BookNotFoundException("Book with ID " + bookId + " not found!");
        }

        Member member = members.get(memberId);
        if (member == null) {
            throw new MemberNotFoundException("Member with ID " + memberId + " not found!");
        }

        if (!book.isAvailable()) {   //if book is already issued means it'll make false.. or else it will make true and enter into if block
            System.out.println("Book is already issued!");
            return;
        }

        member.issueBook(book);
        book.markUnavailable();

        transaction.issueBook(member, book, issueDate);

        System.out.println("Book issued: " + book.getTitle());
    }

    //  RETURN BOOK

    public void returnBook(String bookId, String memberId, String returnDate) {

        Book book = books.get(bookId);
        if (book == null) {
            throw new BookNotFoundException("Book with ID " + bookId + " not found!");
        }

        Member member = members.get(memberId);
        if (member == null) {
            throw new MemberNotFoundException("Member with ID " + memberId + " not found!");
        }

        int fine = transaction.returnBook(member, book, returnDate);

        book.markAvailable();

        System.out.println("Book returned: " + book.getTitle());
        System.out.println("Fine Amount: ₹" + fine);
    }

    // SEARCH BOOK

    public void searchBook(String title) {
        for (Book book : books.values()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isAvailable()) {
                    System.out.println(book.getTitle() + " found and available.");
                } else {
                    System.out.println(book.getTitle() + " found but not available.");
                }
                return;
            }
        }
        throw new BookNotFoundException("No  book found with title" + title);
    }

    //SHOW TRANSACTIONS

    public void showTransactions() {
        transaction.showLogs();
    }
}
