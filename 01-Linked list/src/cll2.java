import java.lang.*;
import java.util.*;
class TicketReservationSystem
{
    class Ticket
    {
        int ticketId;
        String customerName;
        String movieName;
        String seatNumber;
        String bookingTime;
        Ticket next;
        Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
            this.ticketId = ticketId;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.bookingTime = bookingTime;
            this.next = null;
        }
    }
    private Ticket head = null;
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            head.next = head;
        } else {
            Ticket temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTicket;
            newTicket.next = head;
        }
        System.out.println("Ticket booked for " + customerName);
    }
    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }
        Ticket curr = head, prev = null;
        do {
            if (curr.ticketId == ticketId) {
                if (curr == head && curr.next == head) {
                    head = null;
                } else if (curr == head) {
                    Ticket last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = curr.next;
                }
                System.out.println("Ticket ID " + ticketId + " removed.");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);

        System.out.println("Ticket ID " + ticketId + " not found.");
    }
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket temp = head;
        System.out.println("\nAll Booked Tickets:");
        do {
            System.out.println("Ticket ID: " + temp.ticketId + ", Customer: " + temp.customerName +
                    ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }
    public void searchTicket(String keyword) {
        if (head == null) {
            System.out.println("No tickets to search.");
            return;
        }
        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(keyword) || temp.movieName.equalsIgnoreCase(keyword)) {
                System.out.println("Found Ticket -> ID: " + temp.ticketId + ", Customer: " + temp.customerName +
                        ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No ticket found for keyword: " + keyword);
        }
    }
    public int totalTickets() {
        if (head == null) return 0;
        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();
        system.addTicket(101, "Alice", "Dune", "A1", "6:00 PM");
        system.addTicket(102, "Bob", "Dune", "A2", "6:00 PM");
        system.addTicket(103, "Charlie", "Avatar", "B1", "9:00 PM");
        system.displayTickets();
        system.searchTicket("Dune");
        System.out.println("\nTotal Tickets: " + system.totalTickets());
        system.removeTicket(102);
        system.displayTickets();
        System.out.println("\nTotal Tickets after removal: " + system.totalTickets());
    }
}