package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LibraryFunctionalTest {

    @Test
    void testScenarioFonctionnel() {
        Library library = new Library();

        // Ajout de plusieurs livres
        Book book1 = new Book("Le Petit Prince", "Antoine de Saint-Exupéry", 1943);
        Book book2 = new Book("1984", "George Orwell", 1949);
        Book book3 = new Book("Candide", "Voltaire", 1759);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        assertEquals(3, library.books.size(), "La bibliothèque doit contenir 3 livres après ajout");

        // Suppression d'un livre
        library.removeBook("1984");
        assertEquals(2, library.books.size(), "La bibliothèque doit contenir 2 livres après suppression");
        assertNull(library.searchBook("1984"), "Le livre '1984' doit avoir été supprimé");

        // Affichage des livres
        ArrayList<Book> remainingBooks = library.displayBooks();
        assertNotNull(remainingBooks, "La liste des livres affichée ne doit pas être nulle");
        assertEquals(2, remainingBooks.size(), "La liste doit contenir 2 livres après suppression");
        assertTrue(remainingBooks.stream().anyMatch(b -> b.titre.equalsIgnoreCase("Le Petit Prince")));
        assertTrue(remainingBooks.stream().anyMatch(b -> b.titre.equalsIgnoreCase("Candide")));

        //On ne peut pas supprimer un livre qui n'existe plus
        library.removeBook("1984");

        // On peut toujours chercher les livres reste
        Book foundBook = library.searchBook("Candide");
        assertNotNull(foundBook, "Le livre 'Candide' doit être trouvé");
        assertEquals("Voltaire", foundBook.auteur);
    }
}
