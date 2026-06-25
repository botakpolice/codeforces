import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            long k = Long.parseLong(br.readLine());
            long lo = 1, hi = (long) (2e18 + 1);
            long res = (long) (2e18 + 1);

            while (lo < hi) {
                long mid = lo + (hi - lo) / 2;
                long n = mid -isqrt(mid);
                if (n >= k) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }

            System.out.println(lo);
        }

    }

    static long isqrt(long x) {
        long r = (long) Math.sqrt(x);
        while ((r + 1) * (r + 1) <= x) {
            r++;
        } 
        while (r * r > x) {
            r--;
        }

        return r;
    }
}
