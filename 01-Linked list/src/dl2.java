import java.lang.*;
import java.util.*;
class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book next;
    Book prev;
    public Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}
class Library {
    private Book head;
    private Book tail;
    public void addAtBeginning(Book newBook) {
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }
    public void addAtEnd(Book newBook) {
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }
    public void addAtPosition(Book newBook, int position) {
        if (position <= 1) {
            addAtBeginning(newBook);
            return;
        }
        Book current = head;
        int count = 1;
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }
        if (current == null || current.next == null) {
            addAtEnd(newBook);
        } else {
            newBook.next = current.next;
            newBook.prev = current;
            current.next.prev = newBook;
            current.next = newBook;
        }
    }
    public void removeById(int bookId) {
        Book current = head;
        while (current != null && current.bookId != bookId) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Book not found.");
            return;
        }

        if (current == head) {
            head = head.next;
            if (head != null) head.prev = null;
        } else if (current == tail) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        System.out.println("Book removed.");
    }
    public void search(String keyword) {
        Book current = head;
        boolean found = false;
        while (current != null) {
            if (current.title.equalsIgnoreCase(keyword) || current.author.equalsIgnoreCase(keyword)) {
                printBook(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No book found.");
    }
    public void updateAvailability(int bookId, boolean status) {
        Book current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                current.isAvailable = status;
                System.out.println("Availability updated.");
                return;
            }
            current = current.next;
        }
        System.out.println("Book not found.");
    }
    public void displayForward() {
        Book current = head;
        while (current != null) {
            printBook(current);
            current = current.next;
        }
    }
    public void displayReverse() {
        Book current = tail;
        while (current != null) {
            printBook(current);
            current = current.prev;
        }
    }
    public int countBooks() {
        int count = 0;
        Book current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    private void printBook(Book b) {
        System.out.println("ID: " + b.bookId + ", Title: " + b.title + ", Author: " + b.author +
                ", Genre: " + b.genre + ", Available: " + b.isAvailable);
    }
    public static void main(String[] args) {
        Library lib = new Library();

        lib.addAtEnd(new Book("1984", "George Orwell", "Dystopia", 1, true));
        lib.addAtBeginning(new Book("To Kill a Mockingbird", "Harper Lee", "Classic", 2, true));
        lib.addAtPosition(new Book("The Alchemist", "Paulo Coelho", "Fiction", 3, false), 2);

        System.out.println("All books (forward):");
        lib.displayForward();

        System.out.println("\nAll books (reverse):");
        lib.displayReverse();

        System.out.println("\nSearch for 'George Orwell':");
        lib.search("George Orwell");

        System.out.println("\nUpdating availability of book ID 3:");
        lib.updateAvailability(3, true);

        System.out.println("\nRemoving book with ID 2:");
        lib.removeById(2);

        System.out.println("\nBooks after removal:");
        lib.displayForward();

        System.out.println("\nTotal books: " + lib.countBooks());
    }
}