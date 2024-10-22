package codes;

import java.util.*;

public class book_alloacation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int arr_length = sc.nextInt();
            int pages[] = new int[arr_length];
            int stu = sc.nextInt();
            for (int j = 0; j < arr_length; j++) {
                pages[j] = sc.nextInt();
            }
            Arrays.sort(pages);
            System.out.println(largest_distance(pages, stu));
        }
    }

    public static int largest_distance(int[] pages, int stu) {
        int lo = 0; //also can choose it to be the maximum value in the array of books pages
        int hi = 0;
        for (int i = 0; i < pages.length; i++) {
            hi = hi + pages[i];
        }
        int ans = 0;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (ispossible(pages, stu, mid)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    static boolean ispossible(int[] pages, int stu, int mid) {
        int stud = 1;
        int sum = 0;
        int i = 0;
        while (i < pages.length) {
            if (pages[i] + sum <= mid) {
                sum += pages[i];
                i++;
            } else {
                stud++;
                sum = 0;
            }
            if (stud > stu) {
                return false;
            }
        }
        return true;
    }
}