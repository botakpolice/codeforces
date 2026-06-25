import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) {
                break;
            }

            st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken()); // m is the central mgt div

            boolean[][] cannot = new boolean[n + 1][n + 1];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                cannot[a][b] = cannot[b][a] = true;
            }

            List<int[]> edges = new ArrayList<>();

            for (int i = 1; i < n + 1; i++) {
                for (int j = i + 1; j < n + 1; j++) {
                    if (!cannot[i][j]) {
                        edges.add(new int[]{i,j});
                    }
                }
            }

            List<int[]> chosen = new ArrayList<>();
            List<List<int[]>> res = new ArrayList<>();
            System.out.println(n);
            backtrack(0, chosen, res, edges, n, m);
            System.out.println(res.size());
            //for (List<int[]> tree : res) {
            //   System.out.println(tree);
            //}

        }
    }


    static void backtrack(int index, List<int[]> chosen, List<List<int[]>> res, List<int[]> edges, int n, int root) {

        if (chosen.size() == n - 1) {
            if (isTree(chosen, n, root)) {
                res.add(new ArrayList<>(chosen));
            }
            return;
        }

        if (index == edges.size()) {
            return;
        }

        chosen.add(edges.get(index));
        // choose edge
        backtrack(index + 1, chosen, res, edges, n, root);
        chosen.remove(chosen.size() - 1);
        // skip edge
        backtrack(index + 1, chosen, res, edges, n, root);

    }

    static boolean isTree(List<int[]> chosen, int n, int root) {
        List<Integer>[] g = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] e : chosen) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        boolean[] visited = new boolean[n + 1];
        dfs(root, g, visited);

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    static void dfs(int u, List<Integer>[] g, boolean[] vis) {
        vis[u] = true;
        for (int v : g[u]) {
            if (!vis[v]) {
                dfs(v, g, vis);
            }
        }
    }


    static boolean isTreeNoRootRestriction(List<int[]> chosen, int n) {

        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // check for cycles
        for (int[] edge : chosen) {
            if (!union(edge[0], edge[1], parent)) {
                return false;
            }
        }

        // check connectivity
        int root = find(1, parent);
        for (int i = 2; i <= n; i++) {
            if (find(i, parent) != root) {
                return false;
            }
        }

        return true;
    }

    static int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }

        return parent[x];
    }

    static boolean union(int a, int b, int[] parent) {
        int pa = find(a, parent);
        int pb = find(b, parent);
        if (pa == pb) {
            return false;
        }

        parent[pa] = pb;
        return true;
    }


    // this generates unique paths, wrong !
    //static HashSet<String> dfs(int prev, boolean[][] cannot,HashSet<Integer> remaining) {
    //    if (remaining.size() == 0) {
    //        HashSet<String> res = new HashSet<>();
    //        res.add("" + prev);
    //        return res;
    //    }

    //    HashSet<String> subsets = new HashSet<>();
    //    for (int a : remaining) {
    //        if (!cannot[prev][a]) {
    //            HashSet<Integer> next = new HashSet<>(remaining);
    //            next.remove(a);
    //            HashSet<String> prevSubsets = dfs(a, cannot, next);
    //            for (String s : prevSubsets) {
    //                subsets.add(prev + "|" + s);
    //            }
    //        }



    //    }
    //    return subsets;

    //}

}
