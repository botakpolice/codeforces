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
            long k = Long.parseLong(st.nextToken());
            char[] s = br.readLine().toCharArray();
            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            int pos = -1;
            for (int i = 0; i < n; i++) {
                if (s[i] == '0') {
                    pos = i;
                    a[i] = (int) (-1e13);
                }
            }

            long mx = 0;
            long curr = 0;
            for (int i = 0; i < n; i++) {
                curr = Math.max(a[i], curr + a[i]);
                mx = Math.max(curr, mx);
            }

            if (mx > k || (pos == -1 && mx < k)) {
                System.out.println("No");
                continue;
            }

            if (pos != -1) {
                mx = 0;
                curr = 0;
                long l = 0, r = 0;
                for (int i = pos - 1; i >= 0; i--) {
                    curr += a[i];
                    mx = Math.max(curr, mx);
                }

                l = mx;
                curr = 0;
                mx = 0;
                for (int i = pos + 1; i < n; i++) {
                    curr += a[i];
                    mx = Math.max(curr, mx);
                }
                
                r = mx;

                a[pos] = k - l - r;
            }

            StringBuilder sb = new StringBuilder();
            for (long x : a) {
                sb.append(x).append(" ");
            }

            System.out.println("Yes");
            System.out.println(sb.toString().trim());
        }

    }
}
