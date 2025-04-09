import java.io.*;
class InputStreamReaderProblem {
    public static void main(String[] args) {
        String filePath = "C:/MyJava/Strings/dateComparison.java";
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}
