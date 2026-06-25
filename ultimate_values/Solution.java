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

            long ans = 0;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    ans += a[i];
                } else {
                    ans -= a[i];
                }
            }
            
            // swapping even-even and odd-odd indices, diff is the abs difference between r and l
            long init = ans;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    ans = Math.max(ans, init + i);
                } else {
                    ans = Math.max(ans, init + i - 1);
                }
            }

            long min_even = Long.MAX_VALUE / 2;
            long min_odd = Long.MAX_VALUE / 2;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 1) {
                    ans = Math.max(init + i + a[i] + a[i] - min_even, ans);
                    min_odd = Math.min(min_odd, i - a[i] - a[i]);
                } else {
                    ans = Math.max(init + i - a[i] - a[i] - min_odd, ans);
                    min_even = Math.min(min_even, i + a[i] + a[i]);
                }
            }

            System.out.println(ans);
        }

    }
}
