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
            long sum = 0;
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                sum += a[i];
            }
            if (n <= 2) {
                System.out.println(-1);
                continue;
            }



            long lo = 0, hi = (long) (1e18);
            while (lo < hi) {

                long mid = lo + (hi - lo) / 2;
                long k = sum + mid;
                long half_avg = ((k + (n * 2) - 1)/ (n * 2));

                int cnt = 0;
                boolean ok = true;
                for (int i = 0; i < n; i++) {
                    if (a[i] < half_avg) {
                        cnt++;
                    }

                    if (cnt * 2 > n) {
                        ok = false;
                        break;
                    }
                }

                if (!ok) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }

            System.out.println(lo);
        }
    }

}
