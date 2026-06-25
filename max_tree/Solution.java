import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            
            int[] indegrees = new int[n];
            List<Integer>[] g = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                g[i] = new ArrayList<>();
            }
            for (int i = 0; i < n -  1; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken()) - 1;
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                if (x > y) {
                    g[v].add(u);
                    indegrees[u]++;
                } else {
                    g[u].add(v);
                    indegrees[v]++;
                }
            }

            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (indegrees[i] == 0) {
                    q.add(i);
                }
            }

            int[] p = new int[n];
            for (int i = 1; i <= n; i++) {
                int u = q.poll();
                p[u] = i;

                for (int v : g[u]) {
                    indegrees[v]--;
                    if (indegrees[v] == 0) {
                        q.add(v);
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int x : p) {
                sb.append(x).append(" ");
            }

            System.out.println(sb.toString().trim());

        }

    }
}
