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
            long k = Long.parseLong(st.nextToken());
            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++){ 
                a[i] = Long.parseLong(st.nextToken());
            }

            PriorityQueue<long[]> pq = new PriorityQueue<>((x,y) -> Long.compare(x[0], y[0]));

            for (int i = 0; i < n; i++) {

                int j = 0;
                // find the least significant bit
                while (((1L << j) & a[i]) != 0) {
                    j++;
                }
                pq.offer(new long[]{1L << j, i});
            }

            long ans = 0;
            for (int i = 0; i < n; i++) {
                ans += Long.bitCount(a[i]);
            }
            while (k > 0) {
                long[] p = pq.poll();
                if (p[0] <= k) {
                    k -= p[0];
                    int idx = (int) p[1];
                    a[idx] |= p[0];
                    ans++;

                    long j = 0;
                    while (((1L << j) & a[idx]) != 0) {
                        j++;
                    }

                    pq.offer(new long[]{1L << j, idx});
                } else {
                    break;
                }
            }

            System.out.println(ans);
        }

    }
}
