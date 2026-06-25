import java.io.*;
import java.util.*;

public class quotient_and_remainder {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st; 

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long k = Long.parseLong(st.nextToken());

            int[] q = new int[n];
            int[] r = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                q[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                r[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(q);
            Arrays.sort(r);

            int left = 0, right = n + 1;
            while (right - left > 1) {
                int mid = left + (right - left) / 2;
                if (check(mid, q, r, k)) {
                    left = mid; 
                } else {
                    right = mid;
                }
            }

            System.out.println(left);
        }
    }

    static boolean check(int c, int[] q, int[] r, long k) {
        for (int i = 0; i < c; i++) {
            long x = (long) (q[i] + 1) * (r[c - i - 1] + 1) - 1;
            if (x > k) {
                return false;
            }
        }

        return true;
    }
}
