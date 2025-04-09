import java.lang.*;
import java.util.*;
class MatrixSearch {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int left = 0;
        int right = rows * columns - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midRow = mid / columns;
            int midCol = mid % columns;
            if (matrix[midRow][midCol] == target) {
                return true;
            } else if (matrix[midRow][midCol] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;
        boolean result = searchMatrix(matrix, target);
        if (result) {
            System.out.println("Target " + target + " is found in the matrix.");
        } else {
            System.out.println("Target " + target + " is not found in the matrix.");
        }
    }
}
