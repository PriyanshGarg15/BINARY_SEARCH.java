package codes;

import java.util.*;

public class aggressive_cows {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size_of_array = scanner.nextInt();
        int no_of_cows = scanner.nextInt();
        int[] stalls = new int[size_of_array];
        for (int i = 0; i < size_of_array; i++) {
            stalls[i] = scanner.nextInt();
        }
        Arrays.sort(stalls);
        int result = largestMinimumDistance(stalls, no_of_cows);
        System.out.println(result);
    }

    public static int largestMinimumDistance(int[] stalls, int numCows) {
        int lo = 0;
        int hi = stalls[stalls.length - 1] - stalls[0];
        int ans = 0;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (isItPossible(stalls, numCows, mid)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    public static boolean isItPossible(int[] stalls, int numCows, int distance) {
        int position = stalls[0]; // i.e we place first cow here
        int count = 1;
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - position >= distance) {
                count++;
                position = stalls[i];
            }
        }
        return count >= numCows;
    }
}
