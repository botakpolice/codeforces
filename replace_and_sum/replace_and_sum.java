import java.io.*;
import java.util.*;

public class replace_and_sum {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = n - 1; i >= 0; i--) {
                a[i] = Math.max(a[i], b[i]);
                if (i < n - 1) {
                    a[i] = Math.max(a[i], a[i + 1]);
                }
            }

            long[] prefixSum = new long[n + 1];
            for (int i = 0; i < n; i++) {
                prefixSum[i + 1] = prefixSum[i] + a[i];
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < q; i++) {
                st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                sb.append(prefixSum[r] - prefixSum[l - 1]).append(" ");
            }
            System.out.println(sb.toString().trim());

        }
    }
}
