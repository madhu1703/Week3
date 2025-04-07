import java.lang.*;
import java.util.*;
public class ZeroSumSubarrays {
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        int cumulativeSum = 0;
        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];
            if (cumulativeSum == 0) {
                result.add(new int[]{0, i});
            }
            if (sumMap.containsKey(cumulativeSum)) {
                for (int startIndex : sumMap.get(cumulativeSum)) {
                    result.add(new int[]{startIndex + 1, i});
                }
            }
            sumMap.putIfAbsent(cumulativeSum, new ArrayList<>());
            sumMap.get(cumulativeSum).add(i);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {6, -1, -3, 4, 2, 2, -2, 4, 1, -1, -2, 5};
        List<int[]> zeroSumSubarrays = findZeroSumSubarrays(arr);
        for (int[] subarray : zeroSumSubarrays) {
            System.out.println("Subarray from index " + subarray[0] + " to " + subarray[1]);
        }
    }
}

