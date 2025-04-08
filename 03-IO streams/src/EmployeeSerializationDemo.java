import java.io.*;
import java.util.*;
class Employee implements Serializable {
    private int id;
    private String name;
    private String department;
    private double salary;
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee [ID=" + id + ", Name=" + name + ", Department=" + department + ", Salary=" + salary + "]";
    }
}
public class EmployeeSerializationDemo {
    private static final String FILE_NAME = "C:/MyJava/21st march/2.5 dist2.java";
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Alice", "HR", 50000));
        employees.add(new Employee(2, "Bob", "IT", 60000));
        employees.add(new Employee(3, "Charlie", "Finance", 55000));
        serializeEmployees(employees);
        List<Employee> deserializedEmployees = deserializeEmployees();
        System.out.println("\nDeserialized Employee List:");
        for (Employee emp : deserializedEmployees) {
            System.out.println(emp);
        }
    }
    public static void serializeEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("Employees have been serialized to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Serialization Error: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    public static List<Employee> deserializeEmployees() {
        List<Employee> employees = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employees = (List<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization Error: " + e.getMessage());
        }
        return employees != null ? employees : new ArrayList<>();
    }
}

