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
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (b == 0 && c <= n - 3) {
                System.out.println(-1);
                continue;
            }
            if (b == 0 && ((c == n - 1) || (c == n - 2))) {
                System.out.println(n - 1);
                continue;
            }

            if (b == 0 && c >= n) {
                System.out.println(n);
                continue;
            }

            if (c >= n) {
                System.out.println(n);
                continue;
            } else {
                long m = 1 + (n - c - 1) / b;
                System.out.println(Math.max(0, n - m));
            }


        }

    }
}
