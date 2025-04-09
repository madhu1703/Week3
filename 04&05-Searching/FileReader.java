import java.io.*;
import java.util.Scanner;

class FileReaderExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the full path of the file: ");
        String filePath = scanner.nextLine();

        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("File not found at: " + filePath);
            return;
        }

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            System.out.println("\nFile content:\n");
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
