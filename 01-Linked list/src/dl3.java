import java.lang.*;
import java.util.*;
class TextEditor {
    class Node {
        String text;
        Node prev;
        Node next;
        Node(String text) {
            this.text = text;
            this.prev = null;
            this.next = null;
        }
    }
    private Node head;
    private Node tail;
    private Node current;
    private int historySize;
    private int currentSize;
    private final int MAX_HISTORY;
    public TextEditor(int historySize) {
        this.historySize = historySize;
        this.currentSize = 0;
        this.head = null;
        this.tail = null;
        this.current = null;
        this.MAX_HISTORY=10;
    }
    public void addState(String text) {
        Node newNode = new Node(text);
        if (head == null) {
            head = newNode;
            tail = newNode;
            current = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            current = tail;
        }
        if (currentSize == historySize) {
            head = head.next;
            head.prev = null;
        } else {
            currentSize++;
            if (currentSize > MAX_HISTORY) {
                head = head.next;
                if (head != null) head.prev = null;
                currentSize--;
            }
        }
    }
    public String undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            return current.text;
        }
        return "No more undo operations available.";
    }
    public String redo() {
        if (current != null && current.next != null) {
            current = current.next;
            return current.text;
        }
        return "No more redo operations available.";
    }
    public String getCurrentState() {
        if (current != null) {
            return current.text;
        }
        return "No text available.";
    }
    public void showCurrentState() {
        System.out.println("Current Text: " + getCurrentState());
    }

    public void showAllHistory() {
        Node temp = head;
        System.out.print("History: ");
        while (temp != null) {
            System.out.print("[" + temp.text + "] ");
            temp = temp.next;
        }
        System.out.println();
    }
}
class Expression {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10);
        editor.addState("Hello");
        editor.addState("Hello, World");
        editor.addState("Hello, World!");
        editor.showCurrentState();
        editor.undo();
        editor.showCurrentState();
        editor.undo();
        editor.showCurrentState();
        editor.redo();
        editor.showCurrentState();
        editor.addState("Hello Again");
        editor.showCurrentState();
        editor.redo();
        editor.showAllHistory();
    }
}


