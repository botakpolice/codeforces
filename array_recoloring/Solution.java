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
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            if (k > 1) {
                Arrays.sort(a);
                long res = 0;
                for (int i = 0; i <= k; i++) {
                    res += a[n - 1 - i];
                }

                System.out.println(res);
            } else {
                int l = 0;
                for (int i = 0; i < n - 1; i++) {
                    l = Math.max(l, a[i]);
                }

                int r = 0;
                for (int i = 1; i < n; i++) {
                    r = Math.max(r, a[i]);
                }

                System.out.println(Math.max(l + a[n - 1], r + a[0]));
            }
        }

    }
}
