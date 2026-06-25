import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            long res = 0;
            if (a[0] > a[1]) {
                res += a[0] - a[1];
                a[0] = a[1];
            }

            for (int i = 2; i < n; i += 2) {
                int x = a[i - 1] - a[i - 2];
                if (i < n - 1) {
                    x = Math.min(x, a[i + 1]);
                }
                if (a[i] > x) {
                    res += a[i] - x;
                    a[i] = x;
                }
            }

            System.out.println(res);


        }

    }
}
