import java.lang.*;
import java.util.*;
class EmployeeIDSorter {
    public static void insertionSort(int[] employeeIDs) {
        int n = employeeIDs.length;
        for (int i = 1; i < n; i++) {
            int key = employeeIDs[i];
            int j = i - 1;
            while (j >= 0 && employeeIDs[j] > key) {
                employeeIDs[j + 1] = employeeIDs[j];
                j = j - 1;
            }
            employeeIDs[j + 1] = key;
        }
    }
    public static void printArray(int[] array) {
        for (int id : array) {
            System.out.print(id + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] employeeIDs = {105, 102, 109, 101, 107};
        System.out.println("Before sorting:");
        printArray(employeeIDs);
        insertionSort(employeeIDs);
        System.out.println("After sorting:");
        printArray(employeeIDs);
    }
}