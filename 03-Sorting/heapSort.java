import java.lang.*;
import java.util.*;
class SalarySorter {
    public static void heapSort(int[] salaries) {
        int n = salaries.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;
            heapify(salaries, i, 0);
        }
    }
    public static void heapify(int[] salaries, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }
        if (largest != i) {
            int swap = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = swap;
            heapify(salaries, n, largest);
        }
    }
    public static void printArray(int[] array) {
        for (int salary : array) {
            System.out.print(salary + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] salaryDemands = {55000, 42000, 67000, 38000, 60000, 50000};
        System.out.println("Before sorting:");
        printArray(salaryDemands);
        heapSort(salaryDemands);
        System.out.println("After sorting:");
        printArray(salaryDemands);
    }
}

