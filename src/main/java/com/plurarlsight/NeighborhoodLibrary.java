package com.plurarlsight;

import java.util.Scanner;

public class NeighborhoodLibrary {
    private static Book[] books = new Book[20];
    private static int numBooks = 5;

    public static void main(String[] args) throws InterruptedException {
        //Array for books
        books[0] = new Book(92819, "923-3-21-302104-5", "Diary of a Wimpy Kid", false, "");
        books[1] = new Book(38294, "849-2-32-786435-6", "Wonder", false, "");
        books[2] = new Book(93042, "234-4-39-434543-9", "The Hunger Games", false, "");
        books[3] = new Book(63785, "753-2-83-194853-3", "The Maze Runner", false, "");
        books[4] = new Book(40294, "399-8-35-358295-4", "To All The Boys Ive Loved Before", false, "");

        Scanner scanner = new Scanner(System.in);

        boolean isDone = false;
        //Menu that user picks from
        while (!isDone) {
            System.out.println("What would you like to do?");
            System.out.println("1: Show Available Books");
            System.out.println("2: Show Checked Out Books");
            System.out.println("3: Exit");
            System.out.println("Enter your command:");

            String command = scanner.nextLine();
            // Switch case the user can input a command
            switch (command) {
                case "1":
                    allAvailableBooks();
                    checkBookOut(scanner);
                    break;
                case "2":
                    checkInBooks(scanner);
                    break;
                case "3":
                    System.out.println("Exiting!");
                    isDone = true;
                    break;
                default:
                    System.out.println("Invalid Command Try Again");
                    break;
            }


        }
    }

    //Print all available Books
    public static void allAvailableBooks() {
        System.out.println("All Available Books:");

        for (int i = 0; i < numBooks; i++) {
            if (!books[i].isCheckOut()) {
                System.out.println(books[i]);
            }

        }

    }

    //Method to prompt would like to check out a book
    public static void checkBookOut(Scanner scanner) throws InterruptedException {
        System.out.println("Check out a book by name or exit.");
        String checkOutCommand = scanner.nextLine();
        boolean found = false;

        if (checkOutCommand.equalsIgnoreCase("Exit")) {
            return;
        }
        //Will see if the title in array matches the user input title
        for (int i = 0; i < numBooks; i++) {
            if (books[i].getTitle().equalsIgnoreCase(checkOutCommand)) {
                System.out.println("What is your name?: ");
                String userName = scanner.nextLine();

                books[i].setCheckedOutTo(userName);
                books[i].setCheckOut(true);

                System.out.println("Processing...");
                Thread.sleep(1000);
                System.out.println("Done, you've checked out the book.");
                found = true;

            }

        }
        //If book not found it will print the statement
        if (!found){
            System.out.println("No book found, try again.");
        }

    }

    //Method to display checked out books and check in a book
    public static void checkInBooks(Scanner scanner) throws InterruptedException {
        System.out.println("List Of Checked Out Books:");
        boolean booksCheckedOut = false;
        //Will display all checked out books if there is any
        for (int i = 0; i < numBooks; i++) {
            if (books[i].isCheckOut()) {
                System.out.println(books[i]);
                booksCheckedOut = true;
            }
        }
        // If there is no checked out books 'yet' it will print a statement and return to try again
        if (!booksCheckedOut){
                System.out.println("No books currently checked out.");
                return;
            }

        System.out.println("Press C to check in a book or X to go back:");
        String userInput = scanner.nextLine();
        // If the user picks x it will exit and if they pick c it will ask for the book ID
        if (userInput.equalsIgnoreCase("x")){
            System.out.println("Exiting");
            Thread.sleep(1000);
        } else if (userInput.equalsIgnoreCase("c")) {
            System.out.println("Enter book ID to check in:");
            int bookId = scanner.nextInt();
            scanner.nextLine();
            //A boolean to help check if the user id and book id match
            boolean found = false;
            // Goes through the array and continues if the getId is equal to the userid input and if the book is checked out.
            //It will also check in the book selected
            for (int i = 0; i < numBooks; i++) {
                if (books[i].getId() == bookId && books[i].isCheckOut()){
                    books[i].setCheckOut(false);
                    books[i].setCheckedOutTo("");
                    System.out.println("Processing...");
                    Thread.sleep(1000);
                    System.out.println("Book checked in successfully!");
                    found = true;
                    break;
                }

            }
            //If the id is put in wrong or cant be found it will print this out.
            if (!found){
                System.out.println("Invalid ID Try Again.");
            }

        }else {
            System.out.println("Invalid Input Try Again");
        }

    }
}