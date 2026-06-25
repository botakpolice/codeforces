import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }

            int curr = n;
            long ans = Long.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                long s = 0;
                for (int j = 0; j < curr; j++) {
                    s += a[j];
                }

                if (i == 0) {
                    ans = Math.max(s, ans);
                } else {
                    ans = Math.max(ans, Math.max(s, -s));
                }
                for (int j = 0; j < curr - 1; j++) {
                    a[j] = a[j + 1] - a[j];
                }
                curr--;
            }

            System.out.println(ans);

        }

    }
}
