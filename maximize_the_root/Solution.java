import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            List<Integer>[] g = new ArrayList[n];

            for (int i = 0; i < n; i++) {
                g[i] = new ArrayList<>();
            }
            for (int i = 1; i <= n - 1; i++) {
                int x = Integer.parseInt(st.nextToken()) - 1;
                g[x].add(i);
            }
            int res = dfs(a,g,0);

            System.out.println(res);
        }
    }


    static int dfs(int[] a , List<Integer>[] g , int v) {
        if (g[v].size() == 0) {
            return a[v];
        }
        int min = Integer.MAX_VALUE;
        for (int u : g[v]) {
            min = Math.min(min, dfs(a, g, u));
        }

        if (v == 0) {
            return a[v] + min;
        } else {

            return Math.min(min, (a[v] + min) / 2);
        }
    }
}
