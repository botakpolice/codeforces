import java.util.*;

class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] t = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = t[0], m = t[1];
        int[] taken = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int res = 0;
        for (int i = 1; i < taken.length; i++) {
            res += (taken[i] - taken[i - 1] - 2) / 2;
        }

        int circularGap = (taken[0] + n - taken[taken.length - 1] - 2) / 2;
        res += circularGap;

        System.out.println(res);
    }
}
