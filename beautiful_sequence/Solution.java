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

            long[] dp = new long[4];
            long MOD = 998244353;
            dp[0] = 1;
            for(int i = 0; i < n; i++) {
                int x = a[i];
                // each 2 in the current subsequence can be replaced with the current 2 so we get x2 the number of subsequences
                if (x == 2) {
                    dp[x] = (dp[x] + dp[x]) % MOD;
                }

                // forms a new subsequence
                dp[x] = (dp[x] + dp[x - 1]) % MOD;
            } 

            System.out.println(dp[3]);
        }
    }


}
