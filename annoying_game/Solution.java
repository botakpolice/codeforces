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

            st = new StringTokenizer(br.readLine());
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            // first we find the max subarray
            // we only need to check who made the last move

            long[] pre = new long[n];
            long[] post = new long[n];
            for (int i = 0; i < n; i++) {
                if (i > 0 && pre[i - 1] > 0) {
                    pre[i] = pre[i - 1] + a[i];
                } else {
                    pre[i] = a[i];
                }
            }

            for (int i = n - 1; i >= 0; i--){ 
                if (i < n - 1 && post[i + 1] > 0) {
                    post[i] = post[i + 1] + a[i];
                } else {
                    post[i] = a[i];
                }
            }

            // cancellation 
            if (k % 2 == 0) {
                long maxElem = pre[0];
                for (int i = 0; i < n; i++) {
                    maxElem = Math.max(pre[i], maxElem);
                }

                System.out.println(maxElem);
            } else {

                long res = Long.MIN_VALUE;
                for (int i = 0; i < n; i++) {
                    res = Math.max(res, pre[i] + post[i] - a[i] + b[i]);
                }

                System.out.println(res);

            }


        }

    }
}
