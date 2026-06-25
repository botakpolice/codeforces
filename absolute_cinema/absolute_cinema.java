import java.io.*;
import java.util.*;

public class absolute_cinema {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            long[] a = new long[n + 1];
            long[] f = new long[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                f[i] = Long.parseLong(st.nextToken());
            }

            boolean ok = true;
            for (int i = 2; i <= n - 1; i++) {
                if ((f[i + 1] + f[i - 1] - 2 * f[i]) % 2 != 0) {
                    System.out.println("Hello");
                    ok = false;
                    break;
                }
                a[i] = (f[i + 1] + f[i - 1] - 2 * f[i]) / 2; 
            }
            if (ok) {
                long g1 = g(1, f, a);
                long gn = g(n, f, a);
                if (g1 % (n - 1) != 0) {
                    ok = false;
                }
                if (gn % (n - 1) != 0) {
                    ok = false;
                }
                a[1] = gn / (n - 1);
                a[n] = g1 / (n - 1);
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i <= n; i++) {
                    sb.append(a[i]).append(" ");
                }
                System.out.println(sb.toString().trim());
            }
        }
    }
    static long g(int j, long[] f, long[] a) {

        long w = f[j];
        for (int i = 2; i <= f.length - 1; i++) {
            w -= a[i] * Math.abs(i - j);
        }

        return w;
    }
}
