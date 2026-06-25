import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            char[][] g = new char[n][m];
            for (int i = 0; i < n; i++) {
                g[i] = br.readLine().toCharArray();
            }

            if (g[0][0] != g[n - 1][m - 1]) {

                boolean impossible = true;
                for (int j = 1; j < m; j++) {
                    if (g[0][j - 1] != g[0][j] || g[n - 1][j - 1] != g[n - 1][j]) {
                        impossible = false;
                    }
                }

                if (impossible) {
                    System.out.println("NO");
                    continue;
                }

                impossible = true;
                for (int i = 1; i < n; i++) {
                    if (g[i][0] != g[i-1][0] || g[i][m - 1] != g[i - 1][m - 1]) {
                        impossible = false;
                    }
                }

                if (impossible) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }

            } else {
                System.out.println("YES");
            }

        }
    }

}
