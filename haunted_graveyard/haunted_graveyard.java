import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) {
                break;
            }
            int g = Integer.parseInt(br.readLine());
            int[][] grid = new int[n][m];
            for (int i = 0; i < g; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                grid[x][y] = -1;
            }

            int e = Integer.parseInt(br.readLine());
            List<int[]> edges = new ArrayList<>();
            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                edges.add(new int[]{x1,y1,x2,y2,t});
                grid[x1][y1] = 2;
            }

            int[] X = new int[] {-1,1,0,0};
            int[] Y = new int[] {0,0,-1,1}; 
            long[][] cost = new long[n][m];
            for (int i = 0; i < n; i++) {
                Arrays.fill(cost[i], Long.MAX_VALUE);
            }
            cost[0][0] = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == -1 || grid[i][j] == 2 || (i == n - 1 && j == m - 1)) {
                        continue;
                    }

                    for (int k = 0; k < 4; k++) {
                        int dx = X[k];
                        int dy = Y[k];
                        if (i + dx >= 0 && i + dx < n && j + dy >= 0 && j + dy < m) {
                            if (grid[i+dx][j+dy] != -1) {
                                int[] newEdge = new int[]{i,j,i+dx,j+dy,1};
                                edges.add(newEdge);
                            }

                        }
                    }
                }
            }
            for (int i = 0; i < n * m - 1; i++) {
                for (int[] edge : edges) {
                    int x1 = edge[0];
                    int y1 = edge[1];
                    int x2 = edge[2];
                    int y2 = edge[3];
                    int t = edge[4];
                    if (cost[x1][y1] != Long.MAX_VALUE && cost[x1][y1] + t < cost[x2][y2]) {
                        cost[x2][y2] = cost[x1][y1] + t;
                    }
                }
            }
            
            boolean never = false;
            for (int[] edge : edges) {
                int x1 = edge[0], y1 = edge[1];
                int x2 = edge[2], y2 = edge[3];
                int t = edge[4];

                if (cost[x1][y1] != Long.MAX_VALUE && cost[x1][y1] + t < cost[x2][y2]) {
                    never = true;
                    break;
                }
            }
           if (never) {
                System.out.println("Never");
            } else if (cost[n-1][m-1] == Long.MAX_VALUE) {
                System.out.println("Impossible");
            } else {
                System.out.println(cost[n-1][m-1]);
            }


        }
    }
}
