import java.lang.*;
import java.util.*;
public class BinarySearchFirstLast {
    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int firstIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                firstIndex = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return firstIndex;
    }
    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int lastIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                lastIndex = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return lastIndex;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 3, 4, 4, 5, 6};
        int target = 2;
        int firstOccurrence = findFirstOccurrence(arr, target);
        int lastOccurrence = findLastOccurrence(arr, target);
        if (firstOccurrence == -1 || lastOccurrence == -1) {
            System.out.println("Target " + target + " is not found in the array.");
        } else {
            System.out.println("First occurrence of " + target + " is at index: " + firstOccurrence);
            System.out.println("Last occurrence of " + target + " is at index: " + lastOccurrence);
        }
    }
}

