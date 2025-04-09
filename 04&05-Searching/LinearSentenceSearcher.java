import java.lang.*;
import java.util.*;
public class LinearSentenceSearcher {
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }
    public static void main(String[] args) {
        String[] sentences = {
                "The sun rises in the east.",
                "Java is a popular programming language.",
                "This is a sample sentence.",
                "We love problem-solving."
        };
        String wordToSearch = "Java";
        String result = findSentenceWithWord(sentences, wordToSearch);
        System.out.println("Result: " + result);
    }
}

