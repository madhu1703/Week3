import java.io.*;
public class UpperToLowerCaseConverter {
    public static void main(String[] args) {
        String sourceFile = "C:/MyJava/21st march/2.5 dist2.java";
        String destinationFile = "C:/Users/madhumitha/OneDrive/Documents/newnew.java";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(sourceFile), "UTF-8"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destinationFile), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }
            System.out.println("Conversion to lowercase completed successfully.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

