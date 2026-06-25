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
            int m = Integer.parseInt(st.nextToken());

            int[] a = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            long res = 0;
            Arrays.sort(a);
            for (int k = 1; k < n; k++) {
                long x = m - lowerBound(a, k);
                long y = m - lowerBound(a, n - k);
                res += (x * y) - Math.min(x, y); 
            }

            System.out.println(res);

        }
    }

    static int lowerBound(int[] a, int target) {

        int l = 0, r = a.length;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }
}
