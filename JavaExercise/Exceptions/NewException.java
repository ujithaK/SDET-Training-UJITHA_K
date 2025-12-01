package org.example.exception;
import java.util.HashMap;
import java.util.Map;

    public class NewException {


        // creating Invalid input exception
        static class InvalidInputException extends Exception {
            public InvalidInputException(String message) {
                super(message);
            }
        }

        // Creating ResourceNotFound exception
        static class ResourceNotFoundException extends Exception {
            public ResourceNotFoundException(String message) {
                super(message);
            }
        }

        //Creating DatabaseConnection exception
        static class DatabaseConnectionException extends Exception {
            public DatabaseConnectionException(String message) {
                super(message);
            }
        }

        // -------- Fake Library Storage --------
        private static Map<Integer, String> libraryBooks = new HashMap<>();

        public static void main(String[] args) {


            libraryBooks.put(10, "It ends with us");
            libraryBooks.put(20, "Java Basics");

            try {
                // Checking  InavlidInputException
                checkMemberId(10);

                //Checking ResourceNotFound
                searchBook(100);

                // Checking Database exception
                establishConnection(true);

            } catch (InvalidInputException e) {
                System.out.println("[Invalid Input] " + e.getMessage());

            } catch (ResourceNotFoundException e) {
                System.out.println("[Resource Missing] " + e.getMessage());

            } catch (DatabaseConnectionException e) {
                System.out.println("[DB Error] " + e.getMessage());
            } finally {
                System.out.println("\nProcess completed.");
            }
        }
        // if we give Invalid input then it will throw InvalidInputException
        public static void checkMemberId(int id) throws InvalidInputException {
            if (id <= 0) {
                throw new InvalidInputException("Member ID must be a positive number and should not be equal to 0");
            }
            System.out.println("Given  id :" + id+ " is valid");
        }

        // if Book is not found it will throw ResourceNotFoundException
        public static void searchBook(int id) throws ResourceNotFoundException {
            if (!libraryBooks.containsKey(id)) {
                throw new ResourceNotFoundException("No book found with ID: " + id);
            }
            System.out.println("Book available with this id :" + libraryBooks.get(id));
        }

        // throw DatabaseConnectionException
        public static void establishConnection(boolean fail) throws DatabaseConnectionException {
            if (fail) {
                throw new DatabaseConnectionException("Database connection failed!");
            }
            System.out.println("Database connected.");
        }
    }

