import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long k = Long.parseLong(st.nextToken());

            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }

            int l = 0, r = n - 1;
            while (k > 0 && l < r) {
                long min = Math.min(a[l], a[r]);

                if (k < 2 * min) {
                    a[l] -= k / 2 + k % 2;
                    a[r] -= k / 2;
                    k = 0;
                } else {
                    a[l] -= min;
                    a[r] -= min;
                    k -= 2 * min;
                }

                if (a[l] == 0) {
                    l++;
                }

                if (a[r] == 0) {
                    r--;
                }
                
            }

            if (l == r && k >= a[l]) {
                System.out.println(n);
            } else {
                System.out.println(n - (r - l + 1));
            }
            
        }
    }

}
