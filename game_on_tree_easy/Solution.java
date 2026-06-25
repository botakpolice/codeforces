import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        List<Integer>[] tree = new List[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            tree[u].add(v);
            tree[v].add(u);
        }

        int leaf = 0;
        for (int i = 0; i < n; i++) {
            if (tree[i].size() == 1) {
                leaf = i;
                break;
            }
        }

        List<Integer> path = new ArrayList<>();
        dfs(leaf, 0, tree, path);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < t; i++) {
            int x = Integer.parseInt(st.nextToken());

            int idx = path.indexOf(x - 1);
            int left = idx;
            int right = n - 1 - idx;
            if (left % 2 != 0 || right % 2 != 0) {
                System.out.println("Ron");
            } else {
                System.out.println("Hermione");
            }
            // 2 <-> 3 <-> 1
            // 1 <-> 2 <-> 3 <-> 4 <-> 5            
        }
    }

    static void dfs(int u, int p, List<Integer>[] tree, List<Integer> path) {
        path.add(u);
        for (int v : tree[u]) {
            if (v != p) {
                dfs(v, u, tree, path);
            }
        }
    }
}
