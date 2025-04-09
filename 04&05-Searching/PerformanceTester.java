import java.io.*;
import java.util.*;
public class PerformanceTester {
    public static void main(String[] args) {
        compareStringBuilderVsStringBuffer();
        readFileUsingFileReader("largefile.txt");
        readFileUsingInputStreamReader("largefile.txt");
    }
    public static void compareStringBuilderVsStringBuffer() {
        String text = "hello";
        long startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1_000_000; i++) {
            sb.append(text);
        }
        long sbTime = System.currentTimeMillis() - startTime;
        System.out.println("Time taken by StringBuilder: " + sbTime + " ms");
        startTime = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < 1_000_000; i++) {
            sbf.append(text);
        }
        long sbfTime = System.currentTimeMillis() - startTime;
        System.out.println("Time taken by StringBuffer: " + sbfTime + " ms");
    }
    public static void readFileUsingFileReader(String filename) {
        long startTime = System.currentTimeMillis();
        int wordCount = 0;
        try (FileReader fr = new FileReader(filename);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += new StringTokenizer(line).countTokens();
            }
        } catch (IOException e) {
            System.out.println("Error reading file with FileReader: " + e.getMessage());
        }
        long timeTaken = System.currentTimeMillis() - startTime;
        System.out.println("FileReader - Words: " + wordCount + ", Time: " + timeTaken + " ms");
    }
    public static void readFileUsingInputStreamReader(String filename) {
        long startTime = System.currentTimeMillis();
        int wordCount = 0;
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filename));
             BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += new StringTokenizer(line).countTokens();
            }
        } catch (IOException e) {
            System.out.println("Error reading file with InputStreamReader: " + e.getMessage());
        }
        long timeTaken = System.currentTimeMillis() - startTime;
        System.out.println("InputStreamReader - Words: " + wordCount + ", Time: " + timeTaken + " ms");
    }
}
