import java.io.*;
import java.util.*;

public class offshores {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            st = new StringTokenizer(br.readLine());
            long[] a = new long[n];
            long[] transfers = new long[n];
            long total = 0;
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
                transfers[i] = a[i] / x;
                total += transfers[i];
            }

            long max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, (total - transfers[i]) * y + a[i]);
            }

            System.out.println(max);
        }
    }
}
