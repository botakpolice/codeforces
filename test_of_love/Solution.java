import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            char[] s = br.readLine().toCharArray();

            int[] dp = new int[n + 2];
            Arrays.fill(dp, -1);

            dp[0] = k;

            for (int i = 1; i <= n + 1; i++) {

                if (i != n + 1 && s[i - 1] == 'C') {
                    continue;
                }

                for (int x = 1; x <= m; x++) {
                    if (i - x >= 0 && (i - x == 0 || s[i - x - 1] == 'L')) {
                        dp[i] = Math.max(dp[i], dp[i - x]);
                    }
                }

                if (i > 1 && s[i - 2] == 'W') {
                    dp[i] = Math.max(dp[i], dp[i - 1] - 1);
                }

            }

            if (dp[n + 1] >= 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

