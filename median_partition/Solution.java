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
            int[] b = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = b[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(b);
            int m = b[n / 2];
            int[] dp = new int[n];
            int inf = (int) (1e7 + 1);
            for (int i = 0; i < n; i++) {
                dp[i] = -inf;

                int l = 0;
                int e = 0;
                int g = 0;
                for (int j = i; j >= 0; j--) {
                    if (a[j] < m) {
                        l++;
                    } else if (a[j] == m) {
                        e++;
                    } else {
                        g++;
                    }

                    if (l + e > g && g + e > l && (l + g + e) % 2 == 1) {

                        dp[i] = Math.max(dp[i], (j == 0 ? 0 : dp[j - 1]) + 1);
                    }

                }
            }

            System.out.println(dp[n - 1]);
        }

    }
}
