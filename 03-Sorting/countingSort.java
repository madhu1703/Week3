import java.lang.*;
import java.util.*;
class AgeSorter {
    public static void countingSort(int[] ages) {
        int minAge = 10;
        int maxAge = 18;
        int range = maxAge - minAge + 1;
        int[] count = new int[range];
        int[] output = new int[ages.length];
        for (int age : ages) {
            count[age - minAge]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        for (int i = ages.length - 1; i >= 0; i--) {
            int age = ages[i];
            output[count[age - minAge] - 1] = age;
            count[age - minAge]--;
        }
        for (int i = 0; i < ages.length; i++) {
            ages[i] = output[i];
        }
    }
    public static void printArray(int[] array) {
        for (int age : array) {
            System.out.print(age + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] studentAges = {13, 15, 11, 18, 10, 14, 12, 13, 15};
        System.out.println("Before sorting:");
        printArray(studentAges);
        countingSort(studentAges);
        System.out.println("After sorting:");
        printArray(studentAges);
    }
}

