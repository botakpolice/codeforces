import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] vals = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                vals[i] = Integer.parseInt(st.nextToken());
            }

            HashSet<Integer>[] g = new HashSet[n + 1];
            for (int i = 0; i <= n; i++) {
                g[i] = new HashSet<>();
            }
            for (int i = 0; i < n - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                g[u].add(v);
                g[v].add(u);
            }

            int[] down = new int[n + 1];
            int[] heavyLeaf = new int[n + 1];
            dfs1(1, -1, down, heavyLeaf, g);
            System.out.println(Arrays.toString(down));
            System.out.println(Arrays.toString(heavyLeaf));
        }

    }

    static void dfs1(int u, int p, int[] down, int[] heavyLeaf, HashSet<Integer>[] g) {
        down[u] = 0;
        heavyLeaf[u] = u;

        for (int v : g[u]) {
            if (v == p) {
                continue;
            }

            dfs1(v, u, down, heavyLeaf, g);

            if (down[v] + 1 > down[u]) {
                down[u] = down[v] + 1;
                heavyLeaf[u] = heavyLeaf[v];
            }
        }
    }
}
