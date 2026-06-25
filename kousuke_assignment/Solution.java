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

            HashMap<Long,Integer> seen = new HashMap<>();
            seen.put(0L, 0);
            long sum = 0;
            int[] last = new int[n + 1]; 
            for (int i = 1; i <= n; i++) {
                sum += a[i - 1];
                if (seen.containsKey(sum)) {
                    last[i] = seen.get(sum);
                } else {
                    last[i] = -1;
                }
                seen.put(sum, i);
            }

            int[] dp = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                dp[i] = dp[i - 1];
                if (last[i] != -1) {
                    dp[i] = Math.max(dp[i], dp[last[i]] + 1);
                }
            }


            System.out.println(dp[n]);

        }

    }
}
