import java.io.*;
import java.util.*;

public class idiot_first_search {

    static int mod = (int) (1e9 + 7);
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] left = new int[n];
            int[] right = new int[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                left[i] = Integer.parseInt(st.nextToken());
                right[i] = Integer.parseInt(st.nextToken());
                left[i]--; right[i]--;
            }

            long[] dp = new long[n];
            dfs1(0, left, right,  dp);
            dfs2(0, left, right, dp);
            StringBuilder sb = new StringBuilder();
            for (long v : dp) {
                sb.append(v).append(" ");
            }

            System.out.println(sb.toString().trim());

        }
    }

    static long dfs1(int i, int[] left, int[] right, long[] dp) {
        if (left[i] == -1) {
            dp[i] = 1;
            return dp[i];
        }

        // + 2 for moving from left to right
        // + 1 to move to 1 node above
        dp[i] = (dfs1(left[i], left, right, dp) + dfs1(right[i], left, right, dp) + 3) % mod; 
        return dp[i];
    }

    static void dfs2(int i, int[] left, int[] right, long[] dp) {

        if (left[i] == -1) {
            return;
        } 

        dp[left[i]] = (dp[left[i]] + dp[i]) % mod;
        dp[right[i]] = (dp[right[i]] + dp[i]) % mod;
        dfs2(left[i], left, right, dp);
        dfs2(right[i], left, right, dp);

    }

}
