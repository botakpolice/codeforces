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
            int p = 0; 
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
                if (a[i] < a[p]) {
                    p = i;
                }
            }

            long g = 0;
            for (int i = 0; i < n; i++) {
                if (i != p && a[i] % a[p] == 0) {
                    g = gcd(g, a[i]);
                }
            }

            if (g == a[p]) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

    static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
