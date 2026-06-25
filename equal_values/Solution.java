import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }

            boolean ok = true;
            for (int i = 1; i < n; i++) {
                if (a[i] != a[i - 1]) {
                    ok = false;
                }
            }

            if (ok) {
                System.out.println(0);
                continue;
            } else {
                long minCost = Long.MAX_VALUE;
                int prev = 0;
                for (int i = 0; i < n; i++) {
                    if (a[i] != a[prev]) {
                        prev = i;
                    } else {
                        minCost = Math.min(minCost, prev * a[i] + (n - 1 - i) * a[i]);
                    }
                    minCost = Math.min(minCost, i * a[i] + (n - 1 -i) * a[i]); 

                }

                System.out.println(minCost);

            }


        }

    }
}
