import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int c = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < c; tc++) {

            int n = Integer.parseInt(br.readLine());

            List<int[]>[] graph = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 1; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                graph[u].add(new int[]{v, t});
                graph[v].add(new int[]{u, t});
            }

            int m = Integer.parseInt(br.readLine());

            int[] freq = new int[n + 1];
            long totalFreq = 0;

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int j = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                freq[j] += x;
                totalFreq += x;
            }

            long[] totalTime = new long[n + 1];
            long[] subtreeWeight = new long[n + 1];

            boolean[] visited = new boolean[n + 1];
            dfs1(1, subtreeWeight, totalTime, freq, graph, visited);

            visited = new boolean[n + 1];
            dfs2(1, subtreeWeight, totalTime, freq, graph, totalFreq, visited);

            long res = Long.MAX_VALUE;
            List<Integer> centers = new ArrayList<>();

            for (int i = 1; i <= n; i++) {
                if (totalTime[i] < res) {
                    res = totalTime[i];
                    centers = new ArrayList<>();
                }
                if (totalTime[i] == res) {
                    centers.add(i);
                }
            }

            System.out.println(res * 2);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < centers.size(); i++) {
                sb.append(centers.get(i));
                if (i != centers.size() - 1) {   // FIXED spacing bug
                    sb.append(" ");
                }
            }
            System.out.println(sb.toString());
        }
    }

    static void dfs1(int u, long[] subtreeWeight, long[] totalTime,
                     int[] freq, List<int[]>[] graph, boolean[] visited) {

        visited[u] = true;
        subtreeWeight[u] = freq[u];

        for (int[] nei : graph[u]) {
            int v = nei[0], w = nei[1];

            if (!visited[v]) {
                dfs1(v, subtreeWeight, totalTime, freq, graph, visited);
                subtreeWeight[u] += subtreeWeight[v];
                totalTime[1] += subtreeWeight[v] * w;
            }
        }
    }

    static void dfs2(int u, long[] subtreeWeight, long[] totalTime,
                     int[] freq, List<int[]>[] graph,
                     long totalFreq, boolean[] visited) {

        visited[u] = true;

        for (int[] nei : graph[u]) {
            int v = nei[0], w = nei[1];

            if (!visited[v]) {
                totalTime[v] =
                    totalTime[u]
                    - subtreeWeight[v] * w
                    + (totalFreq - subtreeWeight[v]) * w;

                dfs2(v, subtreeWeight, totalTime, freq, graph, totalFreq, visited);
            }
        }
    }
}
