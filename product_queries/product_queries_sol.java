import java.io.*;
import java.util.*;

public class product_queries_sol {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[n + 1];
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                dp[i] = Integer.MAX_VALUE;
            }

            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                dp[a[i]] = 1;
            }

            for (int i = 1; i <= n; i++) {
                if (dp[i] == Integer.MAX_VALUE) {
                    continue;
                }
                for (int j = i; j <= n; j += i) {
                    if (dp[j / i] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dp[j] = Math.min(dp[j], dp[i] + dp[j / i]);
                }
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 1; i <= n; i++) {
                if (dp[i] == Integer.MAX_VALUE) {
                    sb.append(-1);
                } else {
                    sb.append(dp[i]);
                }

                sb.append(" ");
            }

            System.out.println(sb.toString().trim());
        }
    }
}
