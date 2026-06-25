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
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            long[] ans = new long[n];
            for (int i = 0; i < n; i++) {
                ans[i] = lcm(a[i], b[i]);
            }

            boolean ok = true;
            if (ans[0] != a[0]) {
                ok = false;
            }

            if (ans[n - 1] != b[n - 1]) {
                ok = false;
            }

            for (int i = 1; i < n; i++) {
                if (gcd(a[i - 1], ans[i]) != a[i]) {
                    ok = false;
                }
            }

            for (int i = n - 2; i >= 0; i--) {
                if (gcd(b[i + 1], ans[i]) != b[i]) {
                    ok = false;
                }
            }

            if (ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }


    static long lcm(long x, long y) {
        return x * y / gcd(x, y);
    }

    static long gcd(long a, long b) {
        if (a == 0) {
            return b;
        }

        return gcd(b % a, a);
    }
}
