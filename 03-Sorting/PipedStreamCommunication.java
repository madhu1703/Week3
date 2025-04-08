import java.io.*;
public class PipedStreamCommunication {
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);
            Thread writerThread = new Thread(new Writer(pos));
            Thread readerThread = new Thread(new Reader(pis));
            writerThread.start();
            readerThread.start();
        } catch (IOException e) {
            System.out.println("Error connecting streams: " + e.getMessage());
        }
    }
}
class Writer implements Runnable {
    private PipedOutputStream pos;
    public Writer(PipedOutputStream pos) {
        this.pos = pos;
    }
    public void run() {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(pos))) {
            String[] messages = {
                    "Hello from writer thread!",
                    "Java piped streams are cool.",
                    "End of message."
            };
            for (String message : messages) {
                bw.write(message);
                bw.newLine();
                bw.flush();
                Thread.sleep(500);
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Writer error: " + e.getMessage());
        }
    }
}
class Reader implements Runnable {
    private PipedInputStream pis;
    public Reader(PipedInputStream pis) {
        this.pis = pis;
    }
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(pis))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Reader received: " + line);
            }
        } catch (IOException e) {
            System.out.println("Reader error: " + e.getMessage());
        }
    }
}

