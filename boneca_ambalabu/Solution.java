import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] ctr = new int[30];
            st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                for (int j = 0; j < 30; j++) {
                    ctr[j] += ((a[i] >> j) & 1);
                }
            }

            long ans = 0;
            for (int i = 0; i < n; i++) {

                long total = 0;
                for (int j = 0; j < 30; j++) {
                    boolean f = ((a[i] >> j) & 1) == 1;
                    if (f) {
                        total += (1 << j) * (n - ctr[j]);
                    } else {
                        total += (1 << j) * ctr[j];
                    }
                }
                ans = Math.max(ans, total);
            }

            System.out.println(ans);
        }

    }
}
