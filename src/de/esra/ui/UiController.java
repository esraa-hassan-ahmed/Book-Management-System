package de.esra.ui;

import de.esra.model.Book;
import de.esra.logic.BookManager;
import de.rhistel.logic.ConsoleReader;

import java.util.List;

public class UiController {
    private final BookManager bookManager  = new BookManager();

    // Startet das Hauptmenü und wartet auf Benutzereingaben
    public void start() {
        boolean running = true;
        while (running) {
            printMenu();
            String choice = ConsoleReader.in.readMandatoryString();

            switch (choice) {
                case "1" -> addBook();
                case "2" -> removeBook();
                case "3" -> searchBook();
                case "4" -> showAllBooks();
                case "0" -> running = false;
                default -> System.out.println("Ungültige Eingabe. Bitte nochmal versuchen.");
            }
        }
        System.out.println("Programm beendet.");
    }

    // Gibt das Hauptmenü auf der Konsole aus
    private void printMenu() {
        System.out.println("\n--- Bücherverwaltung ---");
        System.out.println("1. Buch hinzufügen");
        System.out.println("2. Buch löschen (mit ISBN)");
        System.out.println("3. Buch suchen (mit ISBN)");
        System.out.println("4. Alle Bücher anzeigen");
        System.out.println("0. Beenden");
        System.out.print("Wähle eine Option: ");
    }

    // Fragt Benutzereingaben ab und fügt ein neues Buch hinzu
    private void addBook() {
        System.out.print("Titel: ");
        String title = ConsoleReader.in.readMandatoryString().trim();

        System.out.print("Autor: ");
        String author = ConsoleReader.in.readMandatoryString().trim();

        System.out.print("ISBN: ");
        String isbn = ConsoleReader.in.readMandatoryString().trim();

        System.out.print("Erscheinungsjahr: ");
        int year = ConsoleReader.in.readInt();

        Book book = new Book(isbn, title, author, year);
        bookManager.addBook(book);

        System.out.println("Buch wurde hinzugefügt.");
    }

    // Entfernt ein Buch anhand der ISBN
    private void removeBook() {
        System.out.print("Gib die ISBN des Buches ein, das gelöscht werden soll: ");
        String isbn = ConsoleReader.in.readMandatoryString().trim();

        boolean removed = bookManager.removeBookByIsbn(isbn);
        if (removed) {
            System.out.println("Buch wurde gelöscht.");
        } else {
            System.out.println("Buch nicht gefunden.");
        }
    }

    // Sucht nach einem Buch anhand der ISBN
    private void searchBook() {
        System.out.print("Gib die ISBN des gesuchten Buches ein: ");
        String isbn = ConsoleReader.in.readMandatoryString().trim();
        Book book = bookManager.searchByIsbn(isbn);
        if (book != null) {
            System.out.println("Gefundenes Buch: " + book);
        } else {
            System.out.println("Kein Buch mit dieser ISBN gefunden.");
        }
    }

    // Zeigt alle gespeicherten Bücher an
    private void showAllBooks() {
        List<Book> books = bookManager.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("Keine Bücher vorhanden.");
        } else {
            System.out.println("Alle Bücher:");
            for (Book book : books) {
                System.out.println("- " + book);
            }
        }
    }
}
