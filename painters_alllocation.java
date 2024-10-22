package codes;

import java.util.*;

public class painters_alllocation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(time(arr, p));
    }

    public static int time(int arr[], int p) {
        int low = arr[0];
        int high = arr[arr.length - 1];
        int result = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(arr, p, mid)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    public static boolean isPossible(int[] arr, int p, int time) {
        int painter = 1;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] + sum <= time) {
                sum = sum + arr[i];
            } else {
                painter++;
                sum = arr[i];
            }
        }
        return painter <= p;
    }
}
