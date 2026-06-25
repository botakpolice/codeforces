import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int[] b = new int[n - 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n - 1; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            int[] a = new int[n];
            a[0] = b[0];
            a[n - 1] = b[n - 2];
            for (int i = 1; i < n - 1; i++) {
                a[i] = b[i] | b[i - 1];
            }

            boolean ok = true;
            for (int i = 0; i < n - 1; i++) {
                if (b[i] != (a[i] & a[i + 1])) {
                    ok = false;
                    break;
                }
            }

            if (!ok) {
                System.out.println(-1);
            } else {
                StringBuilder sb = new StringBuilder();
                for (int x : a) {
                    sb.append(x).append(" ");
                }
                System.out.println(sb.toString().trim());
            }
        }

    }
}
