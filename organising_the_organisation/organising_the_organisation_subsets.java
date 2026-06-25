import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {

            String line = br.readLine();
            if (line == null || line.isEmpty()) {
                break;
            }

            st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            boolean[][] cannot = new boolean[n + 1][n + 1];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                cannot[a][b] = true;
                cannot[b][a] = true;
            }

            for (int i = 1; i <= n; i++) {
                cannot[i][i] = true;
            }

            boolean[] visited = new boolean[n + 1];
            visited[m] = true;
            long totalWays = backtrack(visited, cannot, 1, n);
            System.out.println(totalWays);
        }
    }


    // over counts , not correct. 
    static long backtrack(boolean[] visited, boolean[][] cannot, int count, int n) {
        if (count == n) {
            return 1;
        }

        long res = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {

                for (int parent = 1; parent <= n; parent++) {
                    if (visited[parent] && !cannot[parent][i]) {
                        visited[i] = true;
                        res += backtrack(visited, cannot, count + 1, n);
                        visited[i] = false;
                        break;
                    }
                }
            }
        }

        return res;

    }

}
