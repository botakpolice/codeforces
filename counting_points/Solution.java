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

            long[] a = new long[n];
            long[] r = new long[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                r[i] = Long.parseLong(st.nextToken());
            }

            HashMap<Long,Long> ctr = new HashMap<>();

            for (int i = 0; i < n; i++) {
                long aa = a[i];
                long rr = r[i];

                for (long x = aa - rr; x <= aa + rr; x++) {

                    long val = rr * rr - (x - aa) * (x - aa);
                    long h = 2 * isqrt(val) + 1;

                    ctr.put(x, Math.max(ctr.getOrDefault(x, 0L),h ));
                }
            }

            long ans = 0;
            for (long v : ctr.values()) {
                ans += v;
            }

            System.out.println(ans);
        }

    }

    static long isqrt(long x) {

        long val = (long) Math.sqrt(x) + 5;
        while (val * val > x) {
            val--;
        };

        return val;
    }
}
