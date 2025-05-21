package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private Library library;
    private Book book1;
    private Book book2;
    private Book bookDuplicateTitle;

    @BeforeEach
    void setUp() {
        library = new Library();
        book1 = new Book("Le Petit Prince", "Antoine de Saint-Exupéry", 1943);
        book2 = new Book("1984", "George Orwell", 1949);
        bookDuplicateTitle = new Book("1984", "Another Author", 2000);
    }

    @Test
    void testAddBook() {
        library.addBook(book1);
        assertEquals(1, library.books.size(), "La bibliothèque doit contenir 1 livre après ajout");
        assertTrue(library.books.contains(book1), "Le livre ajouté doit être présent dans la bibliothèque");
    }

    @Test
    void testAddNullBookThrows() {
        assertThrows(IllegalArgumentException.class, () -> library.addBook(null), "Ajouter null doit lancer IllegalArgumentException");
    }

    @Test
    void testAddBookWithEmptyTitle() {
        Book emptyTitleBook = new Book("", "Auteur", 2020);
        library.addBook(emptyTitleBook);
        assertTrue(library.books.contains(emptyTitleBook), "Un livre avec titre vide peut être ajouté");
    }

    @Test
    void testRemoveBookExisting() {
        library.addBook(book1);
        library.addBook(book2);

        library.removeBook("1984");

        assertEquals(1, library.books.size(), "La bibliothèque doit contenir 1 livre après suppression");
        assertFalse(library.books.contains(book2), "Le livre supprimé ne doit plus être dans la bibliothèque");
        assertTrue(library.books.contains(book1), "Le livre non supprimé doit toujours être présent");
    }

    @Test
    void testRemoveBookNonExisting() {
        library.addBook(book1);
        library.removeBook("Titre Inexistant");

        assertEquals(1, library.books.size(), "La bibliothèque ne doit pas changer si le livre à supprimer n'existe pas");
        assertTrue(library.books.contains(book1), "Le livre initial doit toujours être présent");
    }

    @Test
    void testRemoveBookNullTitleThrows() {
        assertThrows(IllegalArgumentException.class, () -> library.removeBook(null), "Supprimer avec un titre null doit lancer IllegalArgumentException");
    }

    @Test
    void testRemoveBookWithEmptyTitle() {
        Book emptyTitleBook = new Book("", "Auteur", 2020);
        library.addBook(emptyTitleBook);

        library.removeBook("");
        assertFalse(library.books.contains(emptyTitleBook), "Le livre avec titre vide doit être supprimé");
        assertEquals(0, library.books.size(), "La bibliothèque doit être vide après suppression");
    }

    @Test
    void testRemoveBookWhenMultipleSameTitle() {
        library.addBook(book2);
        library.addBook(bookDuplicateTitle);

        library.removeBook("1984");
        assertEquals(1, library.books.size(), "Un seul livre avec ce titre doit être supprimé");
        assertTrue(library.books.contains(bookDuplicateTitle) ^ library.books.contains(book2), "Un des deux livres doit rester");
    }

    @Test
    void testSearchBookFound() {
        library.addBook(book1);
        library.addBook(book2);

        Book found = library.searchBook("le petit prince");
        assertNotNull(found, "Le livre recherché doit être trouvé (ignore casse)");
        assertEquals("Le Petit Prince", found.titre, "Le titre du livre trouvé doit correspondre");
    }

    @Test
    void testSearchBookNotFound() {
        library.addBook(book1);
        Book found = library.searchBook("Titre Inexistant");
        assertNull(found, "La recherche d'un livre inexistant doit retourner null");
    }

    @Test
    void testSearchBookNullTitleThrows() {
        assertThrows(IllegalArgumentException.class, () -> library.searchBook(null), "Rechercher avec un titre null doit lancer IllegalArgumentException");
    }

    @Test
    void testDisplayBooksWithBooks() {
        library.addBook(book1);
        library.addBook(book2);

        ArrayList<Book> books = library.displayBooks();
        assertNotNull(books, "La méthode displayBooks doit retourner la liste quand elle n'est pas vide");
        assertEquals(2, books.size(), "La liste retournée doit contenir tous les livres ajoutés");
    }

    @Test
    void testDisplayBooksEmpty() {
        ArrayList<Book> books = library.displayBooks();
        assertNull(books, "La méthode displayBooks doit retourner null quand la bibliothèque est vide");
    }

    @Test
    void testSortBooksByTitle() {
        Book book3 = new Book("Candide", "Voltaire", 1759);
        
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.sortBooksByTitle();

        ArrayList<Book> expectedOrder = new ArrayList<>();
        expectedOrder.add(book2); // "1984"
        expectedOrder.add(book3); // "Candide"
        expectedOrder.add(book1); // "Le Petit Prince"

        assertEquals(expectedOrder, library.displayBooks(), "La liste doit être triée par titre alphabétique");
    }


}