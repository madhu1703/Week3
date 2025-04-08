import java.io.*;
class FileCopy {
    public static void main(String[] args) {
        String sourceFile = "C:/MyJava/21st march/2.5 dist2.java";
        String destinationFile = "C:/Users/madhumitha/OneDrive/Documents/newnew.java";

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            File inputFile = new File(sourceFile);
            if (!inputFile.exists()) {
                System.out.println("Source file does not exist: " + sourceFile);
                return;
            }

            fis = new FileInputStream(inputFile);
            fos = new FileOutputStream(destinationFile);

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            System.out.println("File copied successfully from " + sourceFile + " to " + destinationFile);
        } catch (IOException e) {
            System.out.println("Error occurred during file operation: " + e.getMessage());
        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error closing streams: " + e.getMessage());
            }
        }
    }
}
