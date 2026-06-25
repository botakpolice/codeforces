import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            List<int[]> pairs = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                pairs.add(new int[] {x, p, 1});
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                pairs.add(new int[] {l, r, 0});
            }

            pairs.sort((a,b) -> a[0] - b[0]);
            solve(pairs, m);

        }
    }

    static void solve(List<int[]> pairs, int m) {
        int k = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] p : pairs) {

            if (p[2] == 0) {
                pq.add(-p[1]);
            } else {
                while (!pq.isEmpty() && k < p[1] - p[0] + 2) {
                    k -= pq.poll();
                }

                if (k < p[1] - p[0] + 2) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(m - pq.size());
    }

}
