package de.esra.logic;

import com.sun.tools.jconsole.JConsoleContext;
import de.esra.model.Book;
import de.esra.logic.filehandling.CSVManager;

import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private final List<Book> books;
    private final CSVManager fileHandler;


    public BookManager() {
        fileHandler = CSVManager.getInstance();
        books = fileHandler.loadBooks();
    }

    // Buch hinzufügen
    public void addBook(Book book) {
        books.add(book);
        save();
    }

    // Buch löschen mit ISBN
    public boolean removeBookByIsbn(String isbn) {
        boolean removed =  books.removeIf(book -> book.getIsbn().equals(isbn));
        if (removed) save();
        return removed;
    }

    // Buch suchen mit ISBN
    public Book searchByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().trim().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    // Alle Bücher zurückgeben
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    private void save() {
        fileHandler.saveBooks(books);
    }
}
