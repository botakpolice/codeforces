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


            long[] pre = new long[n];
            long[] suf = new long[n];
            if (a[0] > 0) {
                pre[0] = a[0];
            }

            for (int i = 1; i < n; i++) {
                pre[i] = pre[i - 1];
                if (a[i] > 0) {
                    pre[i] += a[i];
                }
            }

            if (a[n - 1] < 0) {
                suf[n - 1] = -a[n - 1];
            }

            for (int i = n - 2; i >= 0; i--) {
                suf[i] = suf[i + 1];
                if (a[i] < 0) {
                    suf[i] -= a[i];
                }
            }

            long ans = 0;
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, pre[i] + suf[i]);
            }

            System.out.println(ans);

        }

    }
}
