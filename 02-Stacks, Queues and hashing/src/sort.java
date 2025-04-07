import java.lang.*;
import java.util.*;
class SortStack {
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();
            sortStack(stack);
            insertInSortedOrder(stack, top);
        }
    }
    private static void insertInSortedOrder(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
        } else {
            int temp = stack.pop();
            insertInSortedOrder(stack, element);
            stack.push(temp);
        }
    }
    public static void printStack(Stack<Integer> stack) {
        for (int i = 0;i<stack.size();i++) {
            System.out.print(stack.get(i) + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        System.out.println("Original stack:");
        printStack(stack);
        sortStack(stack);
        System.out.println("Sorted stack (ascending order):");
        printStack(stack);
    }
}

