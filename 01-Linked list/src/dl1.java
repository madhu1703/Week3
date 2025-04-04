import java.lang.*;
import java.util.*;
class MovieNode {
    String title;
    String director;
    int year;
    double rating;
    String genre;
    MovieNode next;
    MovieNode prev;

    public MovieNode(String title, String director, int year, double rating, String genre) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.genre = genre;
        this.next = null;
        this.prev = null;
    }
}

class MovieManager {
    private MovieNode head;
    private MovieNode tail;

    public void addAtBeginning(String title, String director, int year, double rating, String genre) {
        MovieNode newNode = new MovieNode(title, director, year, rating, genre);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addAtEnd(String title, String director, int year, double rating, String genre) {
        MovieNode newNode = new MovieNode(title, director, year, rating, genre);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void addAtPosition(int position, String title, String director, int year, double rating, String genre) {
        if (position <= 1 || head == null) {
            addAtBeginning(title, director, year, rating, genre);
            return;
        }

        MovieNode newNode = new MovieNode(title, director, year, rating, genre);
        MovieNode current = head;
        int count = 1;

        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        if (current == tail || current == null) {
            addAtEnd(title, director, year, rating, genre);
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
    }

    public void removeByTitle(String title) {
        MovieNode current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                if (current == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                    else tail = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    if (tail != null) tail.next = null;
                    else head = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                System.out.println("Movie \"" + title + "\" removed.");
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found.");
    }

    public void searchByDirector(String director) {
        MovieNode current = head;
        boolean found = false;
        while (current != null) {
            if (current.director.equalsIgnoreCase(director)) {
                printMovie(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No movies found for director: " + director);
    }

    public void searchByRating(double rating) {
        MovieNode current = head;
        boolean found = false;
        while (current != null) {
            if (current.rating == rating) {
                printMovie(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No movies found with rating: " + rating);
    }

    public void updateRating(String title, double newRating) {
        MovieNode current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                System.out.println("Rating updated for \"" + title + "\".");
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found.");
    }

    public void displayForward() {
        MovieNode current = head;
        if (current == null) {
            System.out.println("No movies in the list.");
            return;
        }
        System.out.println("Movies (Forward):");
        while (current != null) {
            printMovie(current);
            current = current.next;
        }
    }

    public void displayReverse() {
        MovieNode current = tail;
        if (current == null) {
            System.out.println("No movies in the list.");
            return;
        }
        System.out.println("Movies (Reverse):");
        while (current != null) {
            printMovie(current);
            current = current.prev;
        }
    }

    public void searchByGenre(String genre) {
        MovieNode current = head;
        boolean found = false;
        while (current != null) {
            if (current.genre.equalsIgnoreCase(genre)) {
                printMovie(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No movies found in genre: " + genre);
    }

    public void filterByYearRange(int startYear, int endYear) {
        MovieNode current = head;
        boolean found = false;
        while (current != null) {
            if (current.year >= startYear && current.year <= endYear) {
                printMovie(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No movies found in the year range " + startYear + " to " + endYear);
    }

    private void printMovie(MovieNode movie) {
        System.out.println("Title: " + movie.title + ", Director: " + movie.director +
                ", Year: " + movie.year + ", Rating: " + movie.rating + ", Genre: " + movie.genre);
    }
}

class MovieManagementApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieManager manager = new MovieManager();
        manager.addAtEnd("Inception", "Christopher Nolan", 2010, 8.8, "Sci-Fi");
        manager.addAtBeginning("The Matrix", "Wachowski", 1999, 8.7, "Action");
        manager.addAtPosition(2, "Interstellar", "Christopher Nolan", 2014, 8.6, "Sci-Fi");
        manager.displayForward();

        System.out.println();
        manager.displayReverse();

        System.out.println();
        manager.searchByDirector("Christopher Nolan");

        System.out.println();
        manager.searchByRating(8.7);

        System.out.println();
        manager.updateRating("The Matrix", 9.0);

        System.out.println();
        manager.removeByTitle("Inception");

        System.out.println();
        manager.displayForward();
        System.out.println();
        manager.searchByGenre("Sci-Fi");
        System.out.println();
        manager.filterByYearRange(2000, 2014);

        sc.close();
    }
}
