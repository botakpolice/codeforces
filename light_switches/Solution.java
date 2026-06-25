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
            int k = Integer.parseInt(st.nextToken());

            int[] d = new int[2 * k];

            st = new StringTokenizer(br.readLine());

            int mx = -1;
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());

                d[x % (2 * k)]++;
                mx = Math.max(mx, x);
            }

            int cnt = 0;
            int ans = Integer.MAX_VALUE;

            for (int i = 0; i <= k - 2; i++) {
                cnt += d[i];
            }

            for (int l = 0, r = k - 1; l < 2 * k; l++, r++) {

                if (r >= 2 * k) {
                    r -= 2 * k;
                }

                cnt += d[r];

                if (cnt == n) {

                    int wait = (r - mx) % (2 * k);

                    if (wait < 0) {
                        wait += 2 * k;
                    }

                    ans = Math.min(ans, mx + wait);
                }

                cnt -= d[l];
            }

            System.out.println(ans == Integer.MAX_VALUE ? - 1 : ans);
         }

    }
}
