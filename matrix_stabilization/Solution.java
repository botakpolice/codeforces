import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] a = new int[n][m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[] dx = {0,0,-1,1};
            int[] dy = {-1,1,0,0};
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    int mx = -1;
                    for (int k = 0; k < 4; k++) {
                        if (i + dx[k] >= 0 && i + dx[k] < n && j + dy[k] >= 0 && j + dy[k] < m) {
                            mx = Math.max(mx, a[i + dx[k]][j + dy[k]]);
                        }
                    }
                    if (mx >= 0 && mx < a[i][j]) {
                        a[i][j] = mx;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < m; j++) {
                    sb.append(a[i][j]).append(" ");
                }
                System.out.println(sb.toString().trim());
            }

        }

    }
}
