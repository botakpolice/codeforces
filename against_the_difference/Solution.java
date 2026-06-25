import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[n + 1];
            Deque<Integer>[] q = new Deque[n + 1];
            for (int i = 0; i <= n; i++) {
                q[i] = new LinkedList<>();
            }
            for (int i = 1; i <= n; i++) {
                dp[i] = dp[i - 1];
                q[a[i]].addLast(i);
                if (q[a[i]].size() > a[i]) {
                    q[a[i]].pollFirst();
                }

                if (q[a[i]].size() == a[i]) {
                    dp[i] = Math.max(dp[i], dp[q[a[i]].peekFirst() - 1] + a[i]);
                }
            }

            System.out.println(dp[n]);
        }

    }
}
