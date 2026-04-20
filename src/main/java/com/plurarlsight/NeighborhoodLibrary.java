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

            int command = scanner.nextInt();
            scanner.nextLine();

            switch (command) {
                case 1:
                    allAvailableBooks();
                    checkBookOut(scanner);

                    break;
                case 2:

                    break;
                case 3:
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
            System.out.println(books[i]);

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
        for (int i = 0; i < numBooks; i++) {
            if (books[i].getTitle().equalsIgnoreCase(checkOutCommand)) {
                System.out.println("What is your name?: ");
                String userName = scanner.nextLine();

                books[i].setCheckedOutTo(userName);
                books[i].setCheckOut(true);

                System.out.println(books[i] + "| Processing...");
                Thread.sleep(1000);
                System.out.println("Done, you've checked out the book.");
                found = true;

            }

        }
        if (!found){
            System.out.println("No book found, try again.");
        }
    //Method to move book to checked out



    }
}