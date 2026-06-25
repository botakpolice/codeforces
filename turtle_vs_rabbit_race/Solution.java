import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());            
            }

            long[] pre = new long[n + 1];
            for (int i = 0; i < n; i++) {
                pre[i + 1] = pre[i] + a[i]; 
            }
            int q = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < q; i++) {
                st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken()) - 1;
                long u = Long.parseLong(st.nextToken());

                int lo = l, hi = n - 1;
                while (lo <= hi) {
                    int mid = lo + (hi - lo) / 2;
                    long currSections = pre[mid + 1] - pre[l];
                    if (currSections <= u) {
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                }

                long max = Long.MIN_VALUE;
                int optimalI = lo;
                for (int j = Math.max(l, lo - 2); j < Math.min(n, lo + 2); j++) {
                    long currSections = pre[j + 1] - pre[l];
                    long total = u * (currSections) - ((currSections - 1) * (currSections )) / 2;
                    if (total > max) {
                        optimalI = j;
                        max = total;
                    }
                }

                sb.append(optimalI + 1).append(" ");
            }

            System.out.println(sb.toString().trim());

        }
    }

}
