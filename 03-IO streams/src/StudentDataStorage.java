import java.io.*;
public class StudentDataStorage {
    public static void main(String[] args) {
        String filePath = "C:/Users/madhumitha/OneDrive/Documents/newnew.java";
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
            dos.writeInt(101);
            dos.writeUTF("Madhumitha");
            dos.writeDouble(9.01);
            dos.writeInt(102);
            dos.writeUTF("Rahul");
            dos.writeDouble(8.75);
            System.out.println("Student data written successfully.");
        } catch (IOException e) {
            System.out.println("Write Error: " + e.getMessage());
        }
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            while (dis.available() > 0) {
                int rollNo = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll No: " + rollNo);
                System.out.println("Name   : " + name);
                System.out.println("GPA    : " + gpa);
                System.out.println("------------------------");
            }
        } catch (IOException e) {
            System.out.println("Read Error: " + e.getMessage());
        }
    }
}

