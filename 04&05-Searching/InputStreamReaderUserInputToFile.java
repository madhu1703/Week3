import java.io.*;
class InputStreamReaderUserInputToFile {
    public static void main(String[] args) {
        String outputFilePath = "C:/MyJava/Strings/dateComparison.java";
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            FileWriter fileWriter = new FileWriter(outputFilePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            System.out.println("Enter text (type 'exit' to stop):");
            String inputLine;
            while (!(inputLine = bufferedReader.readLine()).equalsIgnoreCase("exit")) {
                bufferedWriter.write(inputLine);
                bufferedWriter.newLine();
            }
            bufferedReader.close();
            bufferedWriter.close();
            System.out.println("User input has been written to: " + outputFilePath);
        } catch (IOException e) {
            System.out.println("An error occurred during input/output operations.");
            e.printStackTrace();
        }
    }
}

