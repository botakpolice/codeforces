import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());
            long s =  n * (2*k + n - 1) / 2;

            long lo = 1L, hi = n, res = -1;
            while(lo <= hi) {

                long mid = lo + (hi - lo) / 2;
                long s1 = (mid * (mid - 1 + 2 * k)) / 2 ;
                long s2 = s - s1;
                if (s1 >= s2) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                    res = mid;
                }
            }

            long s1 = (res * (res - 1 + 2 * k)) / 2;
            long s2 = s - s1;
            long s3 = (res + 1) * (res + 2 * k) / 2;
            long s4 = s - s3;
            System.out.println(Math.min(Math.abs(s1 - s2),Math.abs(s4 - s3)));

        }

    }
}
