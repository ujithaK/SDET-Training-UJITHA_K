package org.example.Libraryy;

//BOOK class
public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean available;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = true;
    }

    // Gettermethods
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getIsbn() {
        return isbn;
    }
    public boolean isAvailable() {
        return available;
    }

    // Settermethod
    public void setAvailable(boolean available) {
        this.available = available;
    }
}

