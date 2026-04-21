package com.plurarlsight;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckOut;
    private String checkedOutTo;
//Constructor
    public Book (int id, String isbn, String title, boolean isCheckedOut, String checkedOutTo) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
    }
//Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckOut() {
        return isCheckOut;
    }

    public void setCheckOut(boolean checkOut) {
        isCheckOut = checkOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }
// To String Method
    @Override
    public String toString() {
        return "Book ID: "+ id + " | Book ISBN: " + isbn + " | Book Title: " + title + " | Checked Out: " + isCheckOut + " | Checked Out Too: " + checkedOutTo;
    }
}



