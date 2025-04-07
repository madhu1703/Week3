import java.lang.*;
import java.util.HashSet;
public class PairWithGivenSum {
    public static boolean hasPairWithSum(int[] arr, int target) {
        HashSet<Integer> visited = new HashSet<>();
        for (int num : arr) {
            int complement = target - num;
            if (visited.contains(complement)) {
                return true;
            }
            visited.add(num);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 3, 2};
        int target = 7;
        if (hasPairWithSum(arr, target)) {
            System.out.println("There exists a pair with the given sum.");
        }
        else
        {
            System.out.println("No pair found with the given sum.");
        }
    }
}

