# 📚 Bücherverwaltungssystem (Book Management System)

---

## 📝 Projektbeschreibung 

Das Bücherverwaltungssystem ist eine Java-Konsolenanwendung, die das einfache Verwalten von Büchern ermöglicht. Benutzer können Bücher hinzufügen, nach ISBN suchen, Bücher löschen und alle Daten persistent in einer CSV-Datei speichern. Das System verwendet eine klare Klassenstruktur mit Singleton-Pattern für Dateioperationen.

## 📝 Project Description

The Book Management System is a Java console application that allows easy management of books. Users can add books, search by ISBN, delete books, and store all data persistently in a CSV file. The system uses a clear class structure with a Singleton pattern for file operations.

---

## 🚀 Funktionen 

- 📗 Bücher hinzufügen (Titel, Autor, ISBN, Jahr)  
- 🔍 Suche nach Büchern per ISBN  
- ❌ Löschen von Büchern per ISBN  
- 💾 Persistente Speicherung in einer CSV-Datei  

## 🚀 Features

- 📗 Add books (title, author, ISBN, year)  
- 🔍 Search books by ISBN  
- ❌ Delete books by ISBN  
- 💾 Persistent storage in a CSV file  

---

## 🏗️ Klassenstruktur 

- 🔹 **Main:** Startet die Anwendung und initiiert die Benutzerinteraktion.  
- 🔹 **UIController:** Steuert die Konsoleneingabe und kommuniziert mit BookManager.  
- 🔹 **BookManager:** Verwaltet die Bücherliste und Geschäftslogik.  
- 🔹 **Book:** Modellklasse mit den Attributen `title`, `author`, `isbn`, `year`.  
- 🔹 **CSVManager (Singleton):** Verantwortlich für das Lesen und Schreiben der CSV-Datei.

## 🏗️ Class Structure

- 🔹 **Main:** Starts the application and initiates user interaction.  
- 🔹 **UIController:** Handles console input and communicates with BookManager.  
- 🔹 **BookManager:** Manages the book list and business logic.  
- 🔹 **Book:** Model class with attributes `title`, `author`, `isbn`, `year`.  
- 🔹 **CSVManager (Singleton):** Responsible for reading and writing the CSV file.

---

## ⚙️ Technische Details 

- 💻 Programmiersprache: Java  
- 📁 Speicherung: CSV-Datei (Beispiel: ISBN, Titel, Autor, Jahr)  
- 🎯 Design Pattern: Singleton (für CSVManager)  
- 📚 Externe Bibliothek: Console Reader für verbesserte Eingabe (optional)

## ⚙️ Technical Details
- 💻 Programming Language: Java  
- 📁 Storage: CSV file (example: ISBN, title, author, year)  
- 🎯 Design Patterns: Singleton (for CSVManager)  
- 📚 External Library: Console Reader for enhanced input (optional)

---

## 📄 CSV Beispiel / CSV Storage Example

```csv
ISBN,Title,Author,Year
"9780132350884","Clean Code","Robert Martin",2008
"9780201633610","Design Patterns","Erich Gamma",1994
