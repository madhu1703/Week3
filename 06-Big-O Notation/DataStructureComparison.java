import java.util.*;
class DataStructureComparison {
    public static void main(String[] args) {
        int N = 1_000_000;
        Random rand = new Random();
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = rand.nextInt(N);
        }
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            hashSet.add(array[i]);
            treeSet.add(array[i]);
        }
        int searchValue = rand.nextInt(N);
        long startTime = System.currentTimeMillis();
        boolean foundInArray = false;
        for (int num : array) {
            if (num == searchValue) {
                foundInArray = true;
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Array Search Time: " + (endTime - startTime) + " ms");
        startTime = System.currentTimeMillis();
        boolean foundInHashSet = hashSet.contains(searchValue);
        endTime = System.currentTimeMillis();
        System.out.println("HashSet Search Time: " + (endTime - startTime) + " ms");
        startTime = System.currentTimeMillis();
        boolean foundInTreeSet = treeSet.contains(searchValue);
        endTime = System.currentTimeMillis();
        System.out.println("TreeSet Search Time: " + (endTime - startTime) + " ms");
    }
}

