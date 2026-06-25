import java.io.*;
import java.util.*;

public class range_operation_prefix {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            long[] pre = new long[n + 1];
            long[] f = new long[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                a[i] = x;
                pre[i + 1] = a[i] + pre[i];
            }

            for (int i = 0; i <= n; i++) {
                f[i] = (long) i * i + i - pre[i];
            }

            long min = f[0];
            long best = 0;
            for (int r = 0; r <= n; r++) {
                best = Math.max(best, f[r] - min);
                min = Math.min(min, f[r]);
            }

            System.out.println(pre[n] + best);
        }
    }
}

 
