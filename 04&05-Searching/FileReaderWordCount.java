import java.io.*;
import java.util.Scanner;
public class FileReaderWordCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the full path of the file: ");
        String filePath = scanner.nextLine();
        System.out.print("Enter the word to search for: ");
        String targetWord = scanner.nextLine().toLowerCase();
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File not found at: " + filePath);
            return;
        }
        int wordCount = 0;
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.toLowerCase().equals(targetWord)) {
                        wordCount++;
                    }
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
        System.out.println("The word '" + targetWord + "' appeared " + wordCount + " times in the file.");
        scanner.close();
    }
}

