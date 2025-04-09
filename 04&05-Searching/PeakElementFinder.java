import java.lang.*;
import java.util.*;
public class PeakElementFinder {
    public static int findPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        int[] nums = {1, 3, 20, 4, 1, 0};
        int peakIndex = findPeakElement(nums);
        System.out.println("Peak element is: " + nums[peakIndex] + " at index " + peakIndex);
    }
}

