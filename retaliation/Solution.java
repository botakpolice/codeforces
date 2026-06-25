import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            if (2 * a[0] - a[1] < 0 || (2 * a[0] - a[1]) % (n + 1) != 0) {
                System.out.println("NO");
                continue;
            }

            long x2 = (2 * a[0] - a[1]) / (n + 1);
            long x1 = a[0] - n * x2;

            if (x1 < 0) {
                System.out.println("NO");
                continue;
            }

            boolean ok = true;
            for (int i = 1; i <= n; i++) {
                if ((a[i - 1] - i * x1 - (n - i + 1) * x2) != 0) {
                    ok = false;
                }
            }

            if (ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }

    }
}
