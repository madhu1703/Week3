import java.io.*;
class ErrorLineReader {
    public static void main(String[] args) {
        String inputFilePath = "C:/Users/madhumitha/OneDrive/Documents/newnew.java";
        String outputFilePath = "C:/Users/madhumitha/OneDrive/Documents/error_lines.txt";
        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    writer.write(line);
                    writer.newLine();
                }
            }
            System.out.println("Matching lines written to: " + outputFilePath);
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
