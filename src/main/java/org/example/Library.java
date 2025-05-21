package org.example;

import java.util.ArrayList;
import java.util.Comparator;

public class Library {
    public ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        books.add(book);
    }

    public void removeBook(String title) {
        if (title == null) {
            throw new IllegalArgumentException("Title cannot be null");
        }

        boolean found = false;

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).titre.equalsIgnoreCase(title)) {
                books.remove(i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No book with title: " + title);
        }
    }

    public Book searchBook(String title) {
        if (title == null) {
            throw new IllegalArgumentException("Title cannot be null");
        }

        for (Book book : books) {
            if (book.titre.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public ArrayList<Book> displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library");
            return null;
        } else {
            return new ArrayList<>(books);
        }
    }

    public void sortBooksByTitle() {
        books.sort(Comparator.comparing(book -> book.titre.toLowerCase()));
    }
}
