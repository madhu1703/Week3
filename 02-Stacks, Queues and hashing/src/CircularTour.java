import java.lang.*;
import java.util.*;
class CircularTour {
    public static int findStartingPump(int[] petrol, int[] distance) {
        int totalPetrol = 0;
        int totalDistance = 0;
        int currentSurplus = 0;
        int startIndex = 0;
        for (int i = 0; i < petrol.length; i++) {
            totalPetrol += petrol[i];
            totalDistance += distance[i];
            currentSurplus += petrol[i] - distance[i];
            if (currentSurplus < 0) {
                startIndex = i + 1;
                currentSurplus = 0;
            }
        }
        if (totalPetrol < totalDistance) {
            return -1;
        }
        return startIndex;
    }
    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};
        int start = findStartingPump(petrol, distance);
        if (start == -1) {
            System.out.println("It is not possible to complete the circular tour.");
        } else {
            System.out.println("The circular tour can be started at pump " + start);
        }
    }
}
