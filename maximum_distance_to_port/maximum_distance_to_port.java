import java.io.*;
import java.util.*;

public class maximum_distance_to_port {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // fill it then get the maximum per product
        int[] c = new int[k + 1];
        int[] p = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            g[u].add(v);
            g[v].add(u);
        }

        // just find shortest path from 0 to n;
        int[] dist = new int[n];
        Arrays.fill(dist, n + 1);
        dist[0] = 0;
        sssp(0,g,dist);
        for (int i = 0; i < n; i++) {
            c[p[i]] = Math.max(c[p[i]] , dist[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= k; i++) {
            sb.append(c[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    static void sssp(int src, List<Integer>[] g, int[] dist) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.add(new int[] {0, src});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0], u = curr[1];
            for (int v : g[u]) {
                if (d + 1 < dist[v]) {
                    dist[v] = d + 1;
                    pq.add(new int[] {d + 1, v});
                }
            } 

        }
    }
}
