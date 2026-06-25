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
            int[] b = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            int j = -1;
            boolean ok = true;
            int m = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (b[i] > a[i]) {
                    if (j == -1) {
                        j = i;
                    } else {
                        ok = false;
                        break;
                    }
                } else {
                    m = Math.min(m, a[i] - b[i]);
                }
            }

            if (!ok) {
                System.out.println("NO");
            } else {
                if (j == -1) {
                    System.out.println("YES");
                } else {
                    if (m >= b[j] - a[j]) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }

                }
            }
        }

    }
}
