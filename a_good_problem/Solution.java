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
            long l = Long.parseLong(st.nextToken());
            long r = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());

            if (n % 2 == 1) {
                System.out.println(l);
                continue;
            }

            if (n == 2) {
                System.out.println(-1);
                continue;
            }

            long res = 1;
            boolean ok = false;
            while (res <= r) {
                if (res > l) {
                    ok = true;
                    if (k <= n - 2) {
                        System.out.println(l);
                    } else {
                        System.out.println(res);
                    }
                    break;
                }
                res *= 2;
            }

            if (!ok) {
                System.out.println(-1);
            }

        }

    }
}
