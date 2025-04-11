import java.util.*;
class SortingComparison {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
    public static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);
            mergeSort(left);
            mergeSort(right);
            merge(arr, left, right);
        }
    }
    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
    public static void main(String[] args) {
        int N = 10_000;
        Random rand = new Random();
        int[] originalArray = new int[N];
        for (int i = 0; i < N; i++) {
            originalArray[i] = rand.nextInt(10_000);
        }
        int[] arr1 = Arrays.copyOf(originalArray, originalArray.length);
        long startTime = System.currentTimeMillis();
        bubbleSort(arr1);
        long endTime = System.currentTimeMillis();
        System.out.println("Bubble Sort Time: " + (endTime - startTime) + " ms");
        int[] arr2 = Arrays.copyOf(originalArray, originalArray.length);
        startTime = System.currentTimeMillis();
        mergeSort(arr2);
        endTime = System.currentTimeMillis();
        System.out.println("Merge Sort Time: " + (endTime - startTime) + " ms");
        int[] arr3 = Arrays.copyOf(originalArray, originalArray.length);
        startTime = System.currentTimeMillis();
        quickSort(arr3, 0, arr3.length - 1);
        endTime = System.currentTimeMillis();
        System.out.println("Quick Sort Time: " + (endTime - startTime) + " ms");
    }
}


