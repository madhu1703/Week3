import java.lang.*;
import java.util.*;
class MyQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public void enqueue(int x) {
        stack1.push(x);
    }
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.enqueue(10);
        q.enqueue(20);
        System.out.println(q.dequeue());
        q.enqueue(40);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
}
