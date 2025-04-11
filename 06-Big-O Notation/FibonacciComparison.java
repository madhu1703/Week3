import java.util.*;
public class FibonacciComparison {
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    public static int fibonacciIterative(int n) {
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
    public static void main(String[] args) {
        int[] testValues = {10, 30, 50};
        for (int n : testValues) {
            System.out.println("Fibonacci for n = " + n);
            long startTime = System.currentTimeMillis();
            try {
                int resultRecursive = fibonacciRecursive(n);
                long endTime = System.currentTimeMillis();
                System.out.println("Recursive Fibonacci: " + resultRecursive);
                System.out.println("Time taken using Recursive: " + (endTime - startTime) + " ms");
            } catch (StackOverflowError e) {
                System.out.println("Recursive Fibonacci: Unfeasible (>1hr)");
            }
            long startTimeIterative = System.currentTimeMillis();
            int resultIterative = fibonacciIterative(n);
            long endTimeIterative = System.currentTimeMillis();
            System.out.println("Iterative Fibonacci: " + resultIterative);
            System.out.println("Time taken using Iterative: " + (endTimeIterative - startTimeIterative) + " ms");

            System.out.println();
        }
    }
}
