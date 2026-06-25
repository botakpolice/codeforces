import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            int curr = 0;
            long[][] dp = new long[n + 1][2];
            for (int i = 1; i <= n; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], Math.abs(dp[i - 1][1])) + a[i - 1];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + a[i - 1];
            }

            System.out.println(Math.max(dp[n][0], Math.abs(dp[n][1])));
        }

    }
}
