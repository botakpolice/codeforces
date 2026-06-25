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
            int m = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            int[] b = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            boolean ok = true;
            if (n == 1) {
                System.out.println("YES");
                continue;
            }


            a[0] = Math.min(a[0], b[0] - a[0]);
            for (int i = 1; i < n; i++) {
                int min = Math.min(a[i], b[0] - a[i]);
                if (min >= a[i - 1]) {
                    a[i] = min;
                } else {
                    int max = Math.max(a[i] , b[0] - a[i]);
                    if (max < a[i - 1]) {
                        ok = false;
                        break;
                    } else {
                        a[i] = max;
                    }
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
