import java.util.*;

public class painter_allocation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // number of test cases
        for (int i = 0; i < t; i++) {
            int num_boards = sc.nextInt();
            int[] boards = new int[num_boards];  // lengths of boards
            int num_painters = sc.nextInt();  // number of painters
            for (int j = 0; j < num_boards; j++) {
                boards[j] = sc.nextInt();
            }
            System.out.println(minimizeTime(boards, num_painters));
        }
    }

    public static int minimizeTime(int[] boards, int num_painters) {
        int lo = 0;
        int hi = 0;

        // sum of all boards (hi), and finding the maximum board length (can be set as lo)
        for (int i = 0; i < boards.length; i++) {
            hi += boards[i];
            lo = Math.max(lo, boards[i]);  // lo could be the maximum board length
        }

        int ans = 0;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            // check if it's possible to paint all boards within 'mid' time
            if (isPossible(boards, num_painters, mid)) {
                ans = mid;  // if possible, this could be our answer
                hi = mid - 1;
            } else {
                lo = mid + 1;  // try a larger time
            }
        }

        return ans;  // minimum time required to paint all boards
    }

    static boolean isPossible(int[] boards, int num_painters, int max_time) {
        int painters_required = 1;
        int time_spent = 0;

        for (int i = 0; i < boards.length; i++) {
            if (time_spent + boards[i] <= max_time) {
                time_spent += boards[i];  // current painter continues painting
            } else {
                painters_required++;  // need a new painter
                time_spent = boards[i];  // the new painter starts with the current board
            }

            // if painters required exceed the available painters, return false
            if (painters_required > num_painters) {
                return false;
            }
        }

        return true;
    }
}
