import java.util.*;


class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int g = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < g; i++) {
            int m = Integer.parseInt(sc.nextLine());
            int[] tiles = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] p = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = p[0], target = p[1];
            long total = factorial(m) / (factorial(n) * factorial(m  - n)); 
            long[][] dp = new long[n + 1][target + 1];
            dp[0][0] = 1;
            for (int t : tiles) {
                for (int j = n; j > 0; j--) {
                    for (int s = target; s >= t; s--) {

                        dp[j][s] += dp[j - 1][s - t];
                    }
                }
            }
            long a = dp[n][target];
            long b = total - a;
            System.out.println(String.format("Game %d -- %d : %d" , i, a, b));


        }

    }

    static long factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}

//import java.util.*;
//
//class Solution {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int g = Integer.parseInt(sc.nextLine());
//
//        for (int tc = 1; tc <= g; tc++) {
//
//            int m = Integer.parseInt(sc.nextLine());
//            int[] tiles = Arrays.stream(sc.nextLine().split(" "))
//                                .mapToInt(Integer::parseInt)
//                                .toArray();
//
//            int[] p = Arrays.stream(sc.nextLine().split(" "))
//                            .mapToInt(Integer::parseInt)
//                            .toArray();
//
//            int n = p[0], target = p[1];
//
//            // DP: dp[j][s] = ways to pick j tiles with sum s
//            long[][] dp = new long[n + 1][target + 1];
//            dp[0][0] = 1;
//
//            for (int t : tiles) {
//                for (int j = n; j >= 1; j--) {
//                    for (int s = target; s >= t; s--) {
//                        dp[j][s] += dp[j - 1][s - t];
//                    }
//                }
//            }
//
//            long ways = dp[n][target];
//            long total = nCr(m, n);
//
//            long notWays = total - ways;
//
//            System.out.println("Game " + tc + " -- " + ways + " : " + notWays);
//        }
//    }
//
//    // nCr (safe, no factorial overflow)
//    static long nCr(int n, int r) {
//        if (r > n) return 0;
//        long res = 1;
//        for (int i = 1; i <= r; i++) {
//            res = res * (n - r + i) / i;
//        }
//        return res;
//    }
//}
