import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int inf = (int) (1e9 + 7);
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            int[] b = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }


            int[] backwardsMatch = new int[m];
            int j = n - 1;
            for (int i = m - 1; i >= 0; i--) {
                while (j >= 0 && a[j] < b[i]) {
                    j--;
                }

                backwardsMatch[i] = j;
                j--;
            }

            int[] forwardsMatch = new int[m];
            j = 0;
            for (int i = 0; i < m; i++) {
                while(j < n && a[j] < b[i]) {
                    j++;
                }

                forwardsMatch[i] = j;
                j++;
            }

            if (forwardsMatch[m - 1] < n) {
                System.out.println(0);
                continue;
            }

            int ans = inf;

            for (int i = 0; i < m; i++) {
                int matchPrevious = (i == 0) ? -1 : forwardsMatch[i - 1];
                int matchNext = (i == m - 1) ? n : backwardsMatch[i + 1];
                if (matchNext > matchPrevious) {
                    ans = Math.min(ans, b[i]);
                }
            }

            if (ans == inf) {
                System.out.println(-1);
            } else {
                System.out.println(ans);
            }


        }
    }

}
