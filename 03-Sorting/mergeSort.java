import java.lang.*;
import java.util.*;
class BookPriceSorter {
    public static void mergeSort(double[] prices, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(prices, left, mid);
            mergeSort(prices, mid + 1, right);
            merge(prices, left, mid, right);
        }
    }
    public static void merge(double[] prices, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        double[] leftArray = new double[n1];
        double[] rightArray = new double[n2];
        for (int i = 0; i < n1; i++)
            leftArray[i] = prices[left + i];
        for (int j = 0; j < n2; j++)
            rightArray[j] = prices[mid + 1 + j];
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                prices[k] = leftArray[i];
                i++;
            } else {
                prices[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            prices[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            prices[k] = rightArray[j];
            j++;
            k++;
        }
    }
    public static void printArray(double[] array) {
        for (double price : array) {
            System.out.print(price + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        double[] bookPrices = {299.99, 499.50, 150.00, 120.75, 320.20};
        System.out.println("Before sorting:");
        printArray(bookPrices);
        mergeSort(bookPrices, 0, bookPrices.length - 1);
        System.out.println("After sorting:");
        printArray(bookPrices);
    }
}

