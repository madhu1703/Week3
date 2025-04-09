import java.lang.*;
import java.util.*;
public class RemoveDuplicates {
    public static String removeDuplicates(String input) {
        StringBuilder result = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (!seen.contains(c)) {
                seen.add(c);
                result.append(c);
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String input = "Hello world";
        String output = removeDuplicates(input);
        System.out.println("String without duplicates: " + output);
    }
}
