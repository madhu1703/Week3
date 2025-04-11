import java.util.*;
class StringConcatPerformance {
    public static void main(String[] args) {
        int N = 100_000;
        int M = 1_000_000;
        System.out.println("Concatenating " + N + " times using String:");
        long startTime = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < N; i++) {
            str += "a";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken using String: " + (endTime - startTime) + " ms");
        System.out.println("\nConcatenating " + M + " times using StringBuilder:");
        startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append("a");
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken using StringBuilder: " + (endTime - startTime) + " ms");
        System.out.println("\nConcatenating " + M + " times using StringBuffer:");
        startTime = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < M; i++) {
            sbf.append("a");
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken using StringBuffer: " + (endTime - startTime) + " ms");
    }
}
