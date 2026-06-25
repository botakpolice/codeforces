import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken()) - 1;
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

            long res = 0;
            for (int i = n - 1; i > k; i--) {
                if (b[i] < a[i]) {
                    res += b[i];
                } else {
                    res += a[i];
                }
            }

            long minPrefix = Long.MAX_VALUE;
            long currCost = 0;
            for (int i = k; i >= 0; i--) {
                long costToLandHere = a[i] + currCost;
                minPrefix = Math.min(minPrefix, costToLandHere);

                currCost += b[i];
            }

            System.out.println(res + minPrefix);
        }
    }

}
