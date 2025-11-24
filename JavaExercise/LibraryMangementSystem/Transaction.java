package org.example.Libraryy;

import java.util.ArrayList;

public class Transaction {

    private ArrayList<String> logs = new ArrayList<>();

    public void issueBook(Member member, Book book, String issueDate) {
        logs.add( book.getTitle() + "is given to "
                + member.getName() + " on " + issueDate);
    }

    public int returnBook(Member member, Book book, String issueDate, String returnDate) {
        long d1 = Long.parseLong(issueDate.substring(8));
        long d2 =Long.parseLong(returnDate.substring(8));

//        System.out.println(d1 +" "+ d2);

        long days = d2-d1;
//        System.out.println("days" + days);
        int fine = 0;

        if (days > 14) {
            fine = (int)((days - 14) * 5); //here 5 is fine per day
        }

        logs.add( book.getTitle() + " is returned by "
                + member.getName() + " on " + returnDate + " with fine amount: ₹" + fine);

        return fine;
    }

    public void showLogs() {

            System.out.println(logs);
    }
}

