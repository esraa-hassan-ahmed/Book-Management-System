package de.esra.logic.filehandling;
import de.esra.model.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVManager {

    // Statische Instanz der Klasse (für Singleton-Pattern)
    private static CSVManager instance;

    // Pfad zur CSV-Datei, in der die Bücher gespeichert werden
    private final String FILE_PATH = "src/de/esra/resources/books.csv";

    // Privater Konstruktor – verhindert direkte Objekterzeugung von außen
    private CSVManager() {}

    // Gibt die Singleton-Instanz zurück (erstellt sie bei Bedarf)
    public static CSVManager getInstance() {
        if (instance == null) {
            instance = new CSVManager(); // Instanz wird nur einmal erzeugt (Lazy Initialization)
        }
        return instance;
    }

    // Bücher speichern
    public void saveBooks(List<Book> books) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Book book : books) {
                String line = String.join(";",
                        book.getIsbn(),
                        book.getTitle(),
                        book.getAuthor(),
                        String.valueOf(book.getYear())
                );
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Bücher wurden gespeichert.");
        } catch (IOException e) {
            System.out.println("Fehler beim Speichern: " + e.getMessage());
        }
    }

    // Bücher laden
    public List<Book> loadBooks() {
        List<Book> books = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) return books;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(";");
                if (fields.length == 4) {
                    Book book = new Book(
                            fields[0],
                            fields[1],
                            fields[2],
                            Integer.parseInt(fields[3])
                    );
                    books.add(book);
                }
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Laden: " + e.getMessage());
        }

        return books;
    }
}
