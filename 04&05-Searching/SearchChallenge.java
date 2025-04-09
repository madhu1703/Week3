import java.lang.*;
import java.util.*;
public class SearchChallenge {
    public static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0 || arr[i] > n) {
                arr[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int num = Math.abs(arr[i]);
            if (num <= n) {
                arr[num - 1] = -Math.abs(arr[num - 1]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        System.out.println("First missing positive: " + findFirstMissingPositive(arr));
        int[] sortedArr = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        int index = binarySearch(sortedArr, target);
        if (index != -1) {
            System.out.println("Target " + target + " is found at index: " + index);
        } else {
            System.out.println("Target " + target + " is not found in the array.");
        }
    }
}

