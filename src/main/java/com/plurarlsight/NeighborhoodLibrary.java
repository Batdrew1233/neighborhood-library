package com.plurarlsight;

import java.util.Scanner;

public class NeighborhoodLibrary {
    private static Book[] books = new Book[20];
    private static int numBooks = 5;
    public static void main(String[] args) {
        //Array for books
        books[0] = new Book(92819,"923-3-21-302104-5", "Diary of a Wimpy Kid", false, "" );
        books[1] = new Book(38294,"849-2-32-786435-6", "Wonder", false, "" );
        books[2] = new Book(93042,"234-4-39-434543-9", "The Hunger Games", false, "" );
        books[3] = new Book(63785,"753-2-83-194853-3", "The Maze Runner", false, "" );
        books[4] = new Book(40294,"399-8-35-358295-4", "To All The Boys Ive Loved Before", false, "" );

        Scanner scanner = new Scanner(System.in);

        boolean isDone = false;
        //Menu that user picks from
        while (!isDone){
            System.out.println("What would you like to do?");
            System.out.println("1: Show Available Books");
            System.out.println("2: Show Checked Out Books");
            System.out.println("3: Exit");

            int command = scanner.nextInt();
            scanner.nextLine();


        }

}}
