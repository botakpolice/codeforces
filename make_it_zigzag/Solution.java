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
            int maxSeen = 0;
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                maxSeen = Math.max(x, maxSeen);
                if (i % 2 == 1) {
                    a[i] = maxSeen;
                } else {
                    a[i] = x;
                }
            }

            long res = 0;
            for (int i = 0; i < n; i+= 2) {
                int diff = -1;
                if (i > 0) {
                    diff = Math.max(diff, a[i] - a[i - 1]);
                }

                if (i < n - 1) {
                    diff = Math.max(diff, a[i] - a[i + 1]);
                }
                res += diff + 1;
            }

            System.out.println(res);
        }

    }
}
