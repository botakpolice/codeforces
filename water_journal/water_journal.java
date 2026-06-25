import java.util.*;

class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] t = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = t[0], min = t[1], max = t[2];
        boolean minSaw = false, maxSaw = false;
        for (int i = 0; i < n - 1; i++) {
            int k = Integer.parseInt(sc.nextLine());
            if (k == min) {
                minSaw = true;
            }

            if (k == max) {
                maxSaw = true;
            }
        }

        if (minSaw && maxSaw) {
            for (int i = min; i <= max; i++) {
                System.out.println(i);
            }
        } else if (!minSaw && maxSaw) {
            System.out.println(min);
        } else if (minSaw && !maxSaw) {
            System.out.println(max);
        } else {
            System.out.println(-1);
        }
    }
}
