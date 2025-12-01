package org.example.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Transaction {

    private String transactionId;
    private String bookId;
    private String memberId;
    private String issueDate;
    private String returnDate;
    private int fineAmount;
    int fine = 0;

    private List<Transaction> logs = new ArrayList<>();

    public Transaction() {}

    public Transaction(String transactionId, String bookId, String memberId,
                       String issueDate, String returnDate, int fineAmount) {
        this.transactionId = transactionId;
        this.bookId = bookId;
        this.memberId = memberId;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.fineAmount = fineAmount;
    }

    // ISSUE
    public void issueBook(Member member, Book book, String issueDate) {

        Transaction t = new Transaction(
                "TXN"+Math.round(Math.random()*10) ,
                book.getBookId(),
                member.getMemberId(),
                issueDate,
                null,
                0
        );

        logs.add(t);
        System.out.println(book.getTitle() + " issued to " + member.getName() + " on " + issueDate);
    }

    //RETURN
    public int returnBook(Member member, Book book, String returnDate) {

        String issueDate = null;

        // Finding last transaction for this book-member
        for (Transaction t : logs) {
            if (t.bookId.equals(book.getBookId()) && t.memberId.equals(member.getMemberId()) && t.returnDate == null) {
                issueDate = t.issueDate;
                break;
            }
        }

        if (issueDate == null) {
            System.out.println("Error: No matching issue transaction found.");
            return 0;
        }

        // Calculate fine

        int d1= Integer.parseInt(returnDate.substring(8));
        int d2= Integer.parseInt(issueDate.substring(8));

        int days = d1-d2;


        if (days > 14) {
            fine = ((days - 14) * 5); // ₹5 per late day
        }

        // Add return transaction entry
        Transaction t = new Transaction(
                "TXN" + System.currentTimeMillis(),
                book.getBookId(),
                member.getMemberId(),
                issueDate,
                returnDate,
                fine
        );

        logs.add(t);

        return fine;
    }

    //CalculateFine..
     public void calculateFine(String returnDate,String issueDate){
         // Calculate fine

         int d1= Integer.parseInt(returnDate.substring(8));
         int d2= Integer.parseInt(issueDate.substring(8));

         int days = d1-d2;


         if (days > 14) {
             fine = ((days - 14) * 5); // ₹5 per late day
         }
         System.out.println(fine);

     }
    // SHOW ALL LOGS
    public void showLogs() {

        if (logs.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }

        for (Transaction t : logs) {
            System.out.println(
                    "\nTransaction ID: " + t.transactionId +
                            "\nBook ID: " + t.bookId +
                            "\nMember ID: " + t.memberId +
                            "\nIssued: " + t.issueDate +
                            "\nReturned: " + (t.returnDate == null ? "Not returned yet" : t.returnDate) +
                            "\nFine: ₹" + t.fineAmount
            );
        }
    }
}
