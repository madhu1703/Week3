import java.lang.*;
import java.util.*;
class ExamScoreSorter {
    public static void selectionSort(int[] scores) {
        int n = scores.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }
    public static void printArray(int[] array) {
        for (int score : array) {
            System.out.print(score + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] examScores = {82, 95, 70, 60, 89, 77};
        System.out.println("Before sorting:");
        printArray(examScores);
        selectionSort(examScores);
        System.out.println("After sorting:");
        printArray(examScores);
    }
}

