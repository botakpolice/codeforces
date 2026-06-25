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
            char[] c = br.readLine().toCharArray();
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            int p = 1;
            int x = 0;
            for (int i = 0; i < n; i++) {
                if (p == 1 && c[i] == 'B') {
                    x++;
                    p = 0;
                } else if (p == 0 && c[i] == 'R') {
                    p = 1;
                }
            }
            // System.out.println(Arrays.toString(c));
            // System.out.println(x);
            if (x <= k) {
                System.out.println(0);
            } else {
                int lo = 0, hi = 0; 
                for (int i = 0; i < n; i++) {
                    hi = Math.max(hi, a[i]);
                }

                while (lo < hi) {
                    int mid = lo + (hi - lo) / 2;
                    if (check(a, c, mid, k)) {
                        hi = mid;
                    } else {
                        lo = mid + 1;
                    }
                }

                System.out.println(lo);

            }

        }
    }

    static boolean check(int[] a, char[] c, int m, int k) {

        int x = 0;
        int n = a.length;
        int p = 1;
        for (int i = 0; i < n; i++) {
            if (a[i] <= m) {
                continue;
            }

            if (p == 1 && c[i] == 'B') {
                x++;
                p = 0;
            } else if (p == 0 && c[i] == 'R') {
                p = 1;
            }
        }

        return x <= k;
    }
}
