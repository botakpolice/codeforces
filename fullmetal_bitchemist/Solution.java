import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            char[] s = br.readLine().toCharArray();
            
            long ans = 0;
            long alt = 0;
            long[] dp = new long[3];
            for (int i = 0; i < n; i++) {
                long[] temp = dp;
                if (s[i] == '1') {
                    temp[0] = dp[2];
                    temp[1] = dp[0] + 1;
                    temp[2] = dp[1];
                } else {
                    temp[0] = dp[1];
                    temp[1] = dp[2];
                    temp[2] = dp[0] + 1;
                }

                dp = temp;

                if (i > 0 && s[i] != s[i - 1]) {
                    alt++;
                } else {
                    alt = 1;
                }

                ans += dp[1] + dp[2] - (alt - 1) / 2;
            }

            System.out.println(ans);

        }
    }

}
