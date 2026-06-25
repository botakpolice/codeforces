import java.io.*;
import java.util.*;

public class test_generator {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long m = Long.parseLong(st.nextToken());

            if (!can(x, m, Long.MAX_VALUE)) {
                System.out.println(-1);
                continue;
            }

            long l = 0, r = (1L << 60);

            while (l <= r) {
                long c = l + (r - l) / 2;

                if (can(x, m, c)) {
                    r = c - 1;
                } else {
                    l = c + 1;
                }
            }
            System.out.println(l);
        }
    }
    static boolean can(long x, long m, long lim) {

        long f = 0;
        for (int i = 59; i >= 0; i--) {
            f <<= 1;

            if (((x >> i) & 1L) == 1L) {
                f++;
            }

            if (((m >> i) & 1L) == 1L) {
                f -= Math.min(lim, f);
            }
        }

        return f == 0;

    }
}
