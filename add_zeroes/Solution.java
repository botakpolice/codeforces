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

            HashMap<Long,List<Long>> g = new HashMap<>();
            for (int i = 1; i < n; i++) {
                long u = a[i] + i;
                long v = u + i;
                if (g.get(u) == null) {
                    g.put(u, new ArrayList<>());
                }
                g.get(u).add(v);
            }

            TreeSet<Long> ts = new TreeSet<>();
            dfs(n, g, ts);
            System.out.println(ts.last());
        }
    }

    static void dfs(long u, HashMap<Long,List<Long>> g, TreeSet<Long> visited) {
        if (visited.contains(u)) {
            return;
        } else {
            visited.add(u);
            List<Long> nei = g.get(u);
            if (nei != null) {
                for (long v : nei) {
                    dfs(v, g, visited);
                }
            }
        }

    }


}
