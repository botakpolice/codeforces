import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());

            while (k > 0 && x != 1) {

                long rem = y - x % y;
                if (rem >= k) {
                    x += k;
                    k = 0;
                } else {
                    x += rem;
                    k -= rem;
                }
                while (x % y == 0) {
                    x /= y;
                }
            }

            System.out.println(x + k % (y - 1));
        }

    }
}
