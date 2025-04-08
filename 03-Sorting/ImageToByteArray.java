import java.io.*;
public class ImageToByteArray {
    public static void main(String[] args) {
        String sourceImagePath = "C:/Users/madhumitha/OneDrive/Documents/pic.jpg";
        String destinationImagePath = "C:/Users/madhumitha/Downloads/picNew.jpg";
        try {
            byte[] imageBytes = imageToByteArray(sourceImagePath);
            byteArrayToImage(imageBytes, destinationImagePath);
            if (compareFiles(sourceImagePath, destinationImagePath)) {
                System.out.println("The new image is identical to the original image.");
            } else {
                System.out.println("The new image is NOT identical to the original image.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static byte[] imageToByteArray(String imagePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(imagePath);
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }
            return byteArrayOutputStream.toByteArray();
        }
    }
    public static void byteArrayToImage(byte[] imageData, String imagePath) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(imagePath)) {
            fos.write(imageData);
            System.out.println("Image has been written to " + imagePath);
        }
    }
    public static boolean compareFiles(String file1, String file2) throws IOException {
        try (FileInputStream fis1 = new FileInputStream(file1);
             FileInputStream fis2 = new FileInputStream(file2)) {
            int byte1, byte2;
            do {
                byte1 = fis1.read();
                byte2 = fis2.read();
                if (byte1 != byte2) {
                    return false;
                }
            } while (byte1 != -1 && byte2 != -1);
            return true;
        }
    }
}
