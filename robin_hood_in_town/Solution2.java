import java.io.*;
import java.util.*;

public class Solution2 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            long sum = 0;
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                sum += a[i];
            }
            if (n <= 2) {
                System.out.println(-1);
                continue;
            }

            Arrays.sort(a);
            // a[n/2] < (sum + x) / 2 * n
            // a[n / 2] * 2 * n - sum < x
            // x > a[n / 2] * 2 * n - sum;

            long x = a[n / 2] * 2 * n - sum + 1;
            System.out.println(Math.max(0,x));

        }
    }

}
