import java.io.*;
import java.util.*;

public class first_or_second {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                long x = Long.parseLong(st.nextToken());
                a[i] = x;
            }

            long[] suffix = new long[n + 1];
            suffix[n] = 0;
            suffix[n - 1] = a[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                suffix[i] = suffix[i + 1] + a[i];
            }

            long y = -suffix[1];
            long x = a[0];
            for (int i = 1; i < n; i++) {
                y = Math.max(y, x - suffix[i + 1]);
                x += Math.abs(a[i]);
            }
            System.out.println(y);
        }
    }
}
