import java.util.*;
import java.io.*;

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

                graph[u].add(new int[] {v , t});
                graph[v].add(new int[] {u, t});
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
            long[] subtreeWeights = new long[n + 1];
            boolean[] visited = new boolean[n + 1];

            totalTime[1] = dfs(1, 0L, subtreeWeights, freq, graph, visited);
            visited = new boolean[n+1];
            reroot(1, subtreeWeights, totalTime, graph, visited, totalFreq);

            long res = Long.MAX_VALUE;
            StringBuilder centers = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                if (totalTime[i] < res) {
                    res = totalTime[i];
                    centers = new StringBuilder();
                }
                if (res == totalTime[i]) {
                    centers.append(i + " ");
                }
            } 

            System.out.println(res * 2);
            System.out.println(centers.toString().trim());


        }

    }

    static long dfs(int u, long d, long[] subtreeWeights, int[] freq, List<int[]>[] graph, boolean[] visited) {

        visited[u] = true;
        subtreeWeights[u] = freq[u];
        long res = subtreeWeights[u] * d; 
        for (int[] nei : graph[u]) {
            int v = nei[0], w = nei[1];
            if (!visited[v]) {
                res += dfs(v, d + w, subtreeWeights, freq, graph, visited);
                subtreeWeights[u] += subtreeWeights[v];
            }
        }

        return res;
    }

    static void reroot(int u, long[] subtreeWeights, long[] totalTime, List<int[]>[] graph, boolean[] visited, long totalFreq) {
        visited[u] = true;
        for (int[] nei : graph[u]) {
            int v = nei[0], w = nei[1];
            if (!visited[v]) {

                totalTime[v] = totalTime[u] - subtreeWeights[v] * w + (totalFreq - subtreeWeights[v]) * w;

                reroot(v, subtreeWeights, totalTime, graph, visited, totalFreq);
            }


        }
    }
}
