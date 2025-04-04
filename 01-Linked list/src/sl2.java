import java.lang.*;
import java.util.*;
class InventoryItem {
    String itemName;
    String itemID;
    int quantity;
    double price;
    InventoryItem next;
    public InventoryItem(String itemName, String itemID, int quantity, double price) {
        this.itemName = itemName;
        this.itemID = itemID;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}
class Inventory {
    private InventoryItem head;
    public void addAtBeginning(String name, String id, int qty, double price) {
        InventoryItem i = new InventoryItem(name, id, qty, price);
        i.next = head;
        head = i;
    }
    public void addAtEnd(String name, String id, int qty, double price) {
        InventoryItem i = new InventoryItem(name, id, qty, price);
        if (head == null) {
            head = i;
            return;
        }
        InventoryItem temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = i;
    }
    public void addAtPosition(String name, String itemID, int qty, double price, int pos) {
        if (pos <= 1 || head == null) {
            addAtBeginning(name, itemID, qty, price);
            return;
        }
        InventoryItem n = new InventoryItem(name, itemID, qty, price);
        InventoryItem temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            addAtEnd(name, itemID, qty, price);
            return;
        }
        n.next = temp.next;
        temp.next = n;
    }
    public void removeById(String id) {
        if (head == null) {
            return;
        }
        if (head.itemID.equals(id)) {
            head = head.next;
            return;
        }
        InventoryItem temp = head;
        while (temp.next != null && !temp.next.itemID.equals(id)) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }
    public void updateQuantity(String id, int newQty) {
        InventoryItem temp = head;
        while (temp != null) {
            if (temp.itemID.equals(id)) {
                temp.quantity = newQty;
                return;
            }
            temp = temp.next;
        }
    }
    public void search(String key) {
        InventoryItem temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.itemID.equalsIgnoreCase(key) || temp.itemName.equalsIgnoreCase(key)) {
                System.out.println("Item Found: " + temp.itemName + " | ID: " + temp.itemID +
                        " | Qty: " + temp.quantity + " | Price: " + temp.price);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("Item not found.");
        }
    }
    public double totalValue() {
        double total = 0;
        InventoryItem temp = head;
        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }
        return total;
    }
    public void sortInventory(String key, boolean ascending) {
        if (head == null || head.next == null)
            return;
        boolean swapped;
        do {
            swapped = false;
            InventoryItem current = head;
            while (current.next != null) {
                boolean shouldSwap = false;

                if (key.equalsIgnoreCase("name")) {
                    int compare = current.itemName.compareToIgnoreCase(current.next.itemName);
                    if (ascending) {
                        if (compare > 0) shouldSwap = true;
                    } else {
                        if (compare < 0) shouldSwap = true;
                    }
                } else if (key.equalsIgnoreCase("price")) {
                    if (ascending) {
                        if (current.price > current.next.price) shouldSwap = true;
                    } else {
                        if (current.price < current.next.price) shouldSwap = true;
                    }
                }
                if (shouldSwap) {
                    swapData(current, current.next);
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }
    private void swapData(InventoryItem a, InventoryItem b) {
        String tempName = a.itemName;
        String tempID = a.itemID;
        int tempQty = a.quantity;
        double tempPrice = a.price;
        a.itemName = b.itemName;
        a.itemID = b.itemID;
        a.quantity = b.quantity;
        a.price = b.price;

        b.itemName = tempName;
        b.itemID = tempID;
        b.quantity = tempQty;
        b.price = tempPrice;
    }
    public void display() {
        InventoryItem temp = head;
        System.out.println("Current Inventory:");
        while (temp != null) {
            System.out.println(temp.itemName + " | ID: " + temp.itemID + " | Qty: " + temp.quantity + " | Price: " + temp.price);
            temp = temp.next;
        }
    }
}
class InventoryManagementApp {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addAtEnd("Keyboard", "I101", 10, 500.0);
        inventory.addAtBeginning("Mouse", "I102", 20, 300.0);
        inventory.addAtEnd("Monitor", "I103", 5, 8000.0);
        inventory.addAtPosition("CPU", "I104", 8, 15000.0, 2);
        inventory.display();
        System.out.println("\nSearching for ID I103:");
        inventory.search("I103");
        System.out.println("\nUpdating quantity of I104:");
        inventory.updateQuantity("I104", 10);
        inventory.display();
        System.out.println("\nRemoving item I102:");
        inventory.removeById("I102");
        inventory.display();
        System.out.println("\nTotal Inventory Value: Rs. " + inventory.totalValue());
        System.out.println("\nSorting by Item Name (ascending):");
        inventory.sortInventory("name", true);
        inventory.display();
        System.out.println("\nSorting by Price (descending):");
        inventory.sortInventory("price", false);
        inventory.display();
    }
}