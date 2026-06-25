import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }

            for (int i = 0; i < n; i++) {
                a[i] += (a[i] % (k + 1)) * k;
            }

            StringBuilder sb = new StringBuilder();
            for (long x : a) {
                sb.append(x).append(" ");
            }
            System.out.println(sb.toString().trim());
        }

    }
}
