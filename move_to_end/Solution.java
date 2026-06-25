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

            long[] suffix = new long[n + 1];
            for (int i = n - 1; i >= 0; i--) {
                suffix[i] = suffix[i + 1] + a[i];
            }

            int[] prefMax = new int[n + 1];
            for (int i = 0; i < n; i++) {
                prefMax[i + 1] = Math.max(prefMax[i], a[i]);
            }

            StringBuilder sb = new StringBuilder();

            for (int k = 0; k < n; k++) {
                sb.append(suffix[n - k] + prefMax[n - k]).append(" "); 
            }

            System.out.println(sb.toString().trim());

        }

    }
}
