import java.lang.*;
import java.util.*;
class ProductPriceSorter {
    public static void quickSort(double[] prices, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(prices, low, high);
            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
        }
    }
    public static int partition(double[] prices, int low, int high) {
        double pivot = prices[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (prices[j] <= pivot) {
                i++;
                double temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }
        double temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;
        return i + 1;
    }
    public static void printArray(double[] array) {
        for (double price : array) {
            System.out.print(price + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        double[] productPrices = {499.99, 199.50, 349.00, 129.99, 275.25};
        System.out.println("Before sorting:");
        printArray(productPrices);
        quickSort(productPrices, 0, productPrices.length - 1);
        System.out.println("After sorting:");
        printArray(productPrices);
    }
}

