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

            boolean ok = false;
            for (int i = 1; i < n; i++) {
                if (Math.abs(a[i - 1] - a[i]) <= 1) {
                    ok = true;
                    break;
                }
            }

            if (ok) {
                System.out.println(0);
                continue;
            }

            for (int i = 1; i + 1 < n; i++) {
                int l = i - 1, r = i + 1;
                if (a[l] < a[i] && a[i] > a[r]) {
                    ok  = true;
                    break;
                }

                if (a[l] > a[i] && a[i] < a[r]) {
                    ok = true;
                    break;
                }
            }

            if (ok) {
                System.out.println(1);
            } else {
                System.out.println(-1);
            }

        }
    }
}
