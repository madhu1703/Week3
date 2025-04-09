import java.lang.*;
import java.util.*;
class StringBufferConcat {
    public static String concatenateStrings(String[] strings) {
        StringBuffer result = new StringBuffer();
        for (String str : strings) {
            result.append(str);
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String[] input = {"Hello", " ", "World", "!", " Welcome", " to", " Java."};
        String output = concatenateStrings(input);
        System.out.println("Concatenated String: " + output);
    }
}
