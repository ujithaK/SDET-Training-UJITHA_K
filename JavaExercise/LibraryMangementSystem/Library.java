package org.example.Libraryy;

import java.util.HashMap;

public class Library {
    private HashMap<String, Book> books = new HashMap<>();     // isbn : Book
    private HashMap<String, Member> members = new HashMap<>(); // memberId : Member
    private Transaction transaction = new Transaction();

    //ADD / REMOVE BOOKS

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
        System.out.println( book.getTitle()+" is added" );
    }

    public void removeBook(String isbn) {
        if (books.containsKey(isbn)) {
            System.out.println(  books.get(isbn).getTitle()+"is removed from the library");
            books.remove(isbn);
        } else {
            System.out.println("Book not found!");
        }
    }

    // MEMBER REGISTRATION

    public void registerMember(Member member) {
        members.put(member.getMemberId(), member);
        System.out.println(member.getName()+" is registered: "  );
    }

    // ISSUE BOOK

    public void issueBook(String isbn, String memberId, String issueDate) {
        if (!books.containsKey(isbn)) {
            System.out.println("Book not found!");
            return;
        }

        Book book = books.get(isbn);

        if (!book.isAvailable()) {
            System.out.println("Book is already issued!");
            return;
        }

        Member mem = members.get(memberId);

        book.setAvailable(false);
        mem.borrowBook(isbn, issueDate);
        transaction.issueBook(mem, book, issueDate);

        System.out.println("Book issued: " + book.getTitle());
    }

    // ---------------- RETURN BOOK ----------------

    public void returnBook(String isbn, String memberId, String returnDate) {
        if (!books.containsKey(isbn)) {
            System.out.println("Book not found!");
            return;
        }

        Book book = books.get(isbn);
        Member mem = members.get(memberId);//it will get particular member with the help of id

        String issueDate = mem.returnBook(isbn);

        if (issueDate == null) {
            System.out.println("Member did not borrow this book!");
            return;
        }

        int fine = transaction.returnBook(mem, book, issueDate, returnDate);
//        System.out.println("issuedate"+issueDate + "return date"+returnDate);
        book.setAvailable(true);

        System.out.println("Book returned: " + book.getTitle());
        System.out.println("Fine Amount: ₹" + fine);
    }

    // ---------------- SEARCH BOOK ----------------

    public void searchBook(String title) {
        for (Book book : books.values()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if( book.isAvailable()){
                    System.out.println(book.getTitle()+" book Found and avaliable" );
                }else{
                    System.out.println( book.getTitle()+" book Found but not avaliable " );
                }

                return;
            }
        }
        System.out.println("Book not found!");
    }

    public void showTransactions() {
        transaction.showLogs();
    }
}

