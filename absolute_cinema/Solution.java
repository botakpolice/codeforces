import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[] f = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                f[i] = Long.parseLong(st.nextToken());
            }

            long[] a = new long[n];
            for (int i = 1; i < n - 1; i++) {
                a[i] = (f[i + 1] + f[i - 1] - 2 * f[i]) / 2;
            }

            long g1 = fun(0,f,a);
            long gn = fun(n-1,f,a);

            a[0] = gn / (n - 1);
            a[n - 1] = g1 / (n - 1);

            StringBuilder sb = new StringBuilder();
            for (long x : a) {
                sb.append(x).append(" ");
            }

            System.out.println(sb.toString().trim());
        }
    }



    static long fun(int i, long[] f, long[] a) {
        long w = f[i];
        for (int j = 1; j < f.length - 1; j++) {
            w -= a[j] * Math.abs(i - j);
        }

        return w;
    }
}
