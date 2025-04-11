import java.io.*;
class LargeFileReadingComparison {
    public static void main(String[] args) {
        String filePath = "C:/MyJava/Strings/dateComparison.java";
        try (FileReader fr = new FileReader(filePath)) {
            long startTime = System.currentTimeMillis();
            int c;
            while ((c = fr.read()) != -1) {
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Time taken using FileReader: " + (endTime - startTime) + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileInputStream fis = new FileInputStream(filePath);
             InputStreamReader isr = new InputStreamReader(fis)) {
            long startTime = System.currentTimeMillis();
            int c;
            while ((c = isr.read()) != -1) {
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Time taken using InputStreamReader: " + (endTime - startTime) + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

