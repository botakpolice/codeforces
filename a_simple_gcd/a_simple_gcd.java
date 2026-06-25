import java.io.*;
import java.util.*;

public class a_simple_gcd {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            long[] a = new long[n];
            long[] b = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                b[i] = Long.parseLong(st.nextToken());
            }

            int res = 0;
            if (n > 1 && gcd(a[0], a[1]) < a[0]) {
                res++;
            }
            
            for (int i = 1; i < n - 1; i++) {
                long left = gcd(a[i], a[i - 1]);
                long right = gcd(a[i], a[i + 1]);

                long target = (left * right) / gcd(left, right);
                if (target < a[i]) {
                    res++;
                }

            }

            if (n > 1 && gcd(a[n - 1], a[n - 2]) < a[n-1]) {
                res++;
            }


            System.out.println(res);

        }

    }

    static long gcd(long a , long b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
