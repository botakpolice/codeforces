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
            int[] l = new int[n];
            int[] r = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                l[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                r[i] = Integer.parseInt(st.nextToken());
            }

            int[] a = new int[n];
            int[] b = new int[n];
            long y = 0;
            for (int i = 0; i < n; i++) {
                a[i] = Math.max(l[i], r[i]);
                b[i] = Math.min(l[i], r[i]);
                y += a[i];
            }

            Arrays.sort(b);
            for (int i = 0; i < k - 1; i++) {
                y += b[n - 1 - i];
            }

            System.out.println(y + 1);
        }

    }
}
