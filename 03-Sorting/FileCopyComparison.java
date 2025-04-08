import java.io.*;
class FileCopyComparison {
    private static final int BUFFER_SIZE = 4096;
    public static void main(String[] args) {
        String sourceFile = "C:/MyJava/21st march/2.5 dist2.java";
        String destUnbuffered = "file:///C:/Users/madhumitha/OneDrive/Documents/newFile.javafile:///C:/Users/madhumitha/OneDrive/Documents/newFile.java";
        String destBuffered = "C:/Users/madhumitha/OneDrive/Documents/newnew.java";
        long unbufferedTime = copyUsingUnbufferedStreams(sourceFile, destUnbuffered);
        System.out.println("Unbuffered Copy Time: " + unbufferedTime + " nanoseconds");
        long bufferedTime = copyUsingBufferedStreams(sourceFile, destBuffered);
        System.out.println("Buffered Copy Time: " + bufferedTime + " nanoseconds");
        System.out.println("\nBuffered copy was " +
                ((double) unbufferedTime / bufferedTime) + " times faster than unbuffered (approx).");
    }
    public static long copyUsingUnbufferedStreams(String source, String dest) {
        long start = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Unbuffered Error: " + e.getMessage());
        }
        return System.nanoTime() - start;
    }
    public static long copyUsingBufferedStreams(String source, String dest) {
        long start = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Buffered Error: " + e.getMessage());
        }
        return System.nanoTime() - start;
    }
}

