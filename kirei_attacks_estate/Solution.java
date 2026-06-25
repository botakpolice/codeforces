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

            List<Integer>[] g = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                g[i] = new ArrayList<>();
            }
            for (int i = 0; i < n - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken()) - 1;
                g[u].add(v);
                g[v].add(u);
            }

            long[] res = new long[n];
            dfs(0,-1,0,0,res,a,g);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(res[i]).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }

    static void dfs(int u, int p, long mini, long maxi, long[] res, long[] a, List<Integer>[] g) {
        res[u] = Math.max(a[u], mini * -1 + a[u]);
        mini = Math.min(a[u], maxi * -1 + a[u]);
        for (int v : g[u]) {
            if (v == p) {
                continue;
            }
            dfs(v,u,mini,res[u],res,a,g);
        }
    }
}
