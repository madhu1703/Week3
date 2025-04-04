import java.lang.*;
import java.util.*;
class Student {
    int rollNumber;
    String name;
    int age;
    String grade;
    Student next;
    Student(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}
class StudentManagement {
    private Student head = null;
    public void addAtBeginning(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }
    public void addAtEnd(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }
    public void addAtPosition(int position, int rollNumber, String name, int age, String grade) {
        if (position < 1) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            addAtBeginning(rollNumber, name, age, grade);
            return;
        }
        Student newStudent = new Student(rollNumber, name, age, grade);
        Student temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        newStudent.next = temp.next;
        temp.next = newStudent;
    }
    public void deleteByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.rollNumber == rollNumber) {
            head = head.next;
            System.out.println("Record deleted.");
            return;
        }
        Student current = head;
        while (current.next != null && current.next.rollNumber != rollNumber) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Record not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Record deleted.");
        }
    }
    public void searchByRollNumber(int rollNumber) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                System.out.println("Student Found: Roll No: " + temp.rollNumber + ", Name: " + temp.name +
                        ", Age: " + temp.age + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }
    public void displayAll() {
        if (head == null) {
            System.out.println("No records found.");
            return;
        }

        Student temp = head;
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNumber + ", Name: " + temp.name +
                    ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
    public void updateGrade(int rollNumber, String newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                temp.grade = newGrade;
                System.out.println("Grade updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }
}
class Main {
    public static void main(String[] args) {
        StudentManagement manager = new StudentManagement();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Student Record Management ---");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Delete by Roll Number");
            System.out.println("5. Search by Roll Number");
            System.out.println("6. Display All");
            System.out.println("7. Update Grade by Roll Number");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            int roll, age, pos;
            String name, grade;
            switch (choice) {
                case 1:
                    System.out.print("Enter Roll Number, Name, Age, Grade: ");
                    roll = sc.nextInt(); sc.nextLine();
                    name = sc.nextLine();
                    age = sc.nextInt(); sc.nextLine();
                    grade = sc.nextLine();
                    manager.addAtBeginning(roll, name, age, grade);
                    break;
                case 2:
                    System.out.print("Enter Roll Number, Name, Age, Grade: ");
                    roll = sc.nextInt(); sc.nextLine();
                    name = sc.nextLine();
                    age = sc.nextInt(); sc.nextLine();
                    grade = sc.nextLine();
                    manager.addAtEnd(roll, name, age, grade);
                    break;
                case 3:
                    System.out.print("Enter Position: ");
                    pos = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Roll Number, Name, Age, Grade: ");
                    roll = sc.nextInt(); sc.nextLine();
                    name = sc.nextLine();
                    age = sc.nextInt(); sc.nextLine();
                    grade = sc.nextLine();
                    manager.addAtPosition(pos, roll, name, age, grade);
                    break;
                case 4:
                    System.out.print("Enter Roll Number to delete: ");
                    roll = sc.nextInt();
                    manager.deleteByRollNumber(roll);
                    break;
                case 5:
                    System.out.print("Enter Roll Number to search: ");
                    roll = sc.nextInt();
                    manager.searchByRollNumber(roll);
                    break;
                case 6:
                    manager.displayAll();
                    break;
                case 7:
                    System.out.print("Enter Roll Number: ");
                    roll = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter new Grade: ");
                    grade = sc.nextLine();
                    manager.updateGrade(roll, grade);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
        sc.close();
    }
}

