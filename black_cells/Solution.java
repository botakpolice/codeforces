import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }

            if (n % 2 == 0) {
                long res = 0;
                for (int i = 0; i < n; i+= 2) {
                    res = Math.max(res, a[i + 1] - a[i]);
                }

                System.out.println(res);
            } else {

                if (n == 1) {
                    System.out.println(1);
                    continue;
                }


                long[] prefix = new long[n];
                long[] suffix = new long[n];

                prefix[1] = a[1] - a[0];
                suffix[n - 2] = a[n - 1] - a[n - 2];

                for (int i = 3; i < n; i+= 2) {
                    prefix[i] = Math.max(prefix[i - 2], a[i] - a[i - 1]);
                }

                for (int i = n - 4; i >= 0; i-=2) {
                    suffix[i] = Math.max(suffix[i + 2], a[i + 1] - a[i]);
                }

                long res = 0;

                for (int i = 1; i < n - 1; i+=2) {
                    long curr_k = Math.min(prefix[i], suffix[i]);
                    res = Math.max(res, curr_k);
                }

                System.out.println(res);
            }

        }

    }
}
