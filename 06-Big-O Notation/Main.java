import java.util.*;
class SearchComparison {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
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
        int N = 1_000_000;
        int[] data = new int[N];
        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            data[i] = rand.nextInt(10_000_000);
        }
        int target = data[rand.nextInt(N)];
        long startTime = System.nanoTime();
        int linearResult = linearSearch(data, target);
        long endTime = System.nanoTime();
        long linearDuration = (endTime - startTime) / 1_000_000;
        Arrays.sort(data);
        startTime = System.nanoTime();
        int binaryResult = binarySearch(data, target);
        endTime = System.nanoTime();
        long binaryDuration = (endTime - startTime) / 1_000_000;
        System.out.println("Target: " + target);
        System.out.println("Linear Search: Found at index " + linearResult + ", Time = " + linearDuration + " ms");
        System.out.println("Binary Search: Found at index " + binaryResult + ", Time = " + binaryDuration + " ms");
    }
}
