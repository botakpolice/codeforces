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
            int[][] b = new int[n][m];

            for (int i = 0; i < n; i++) {
                a[i] = br.readLine().chars().map(c -> c - '0').toArray();
            }

            for (int i = 0; i < n; i++) {
                b[i] = br.readLine().chars().map(c -> c - '0').toArray();
            }

            int[] rowSum1 = new int[n];
            int[] colSum1 = new int[m];
            int[] rowSum2 = new int[n];
            int[] colSum2 = new int[m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    rowSum1[i] += a[i][j];
                    colSum1[j] += a[i][j];
                    rowSum2[i] += b[i][j];
                    colSum2[j] += b[i][j];
                }
            }

            boolean ok = true;
            for (int i = 0; i < n; i++) {
                if (rowSum1[i] % 3 != rowSum2[i] % 3) {
                    ok = false;
                }
            }

            for (int i = 0; i < m; i++) {
                if (colSum1[i] % 3 != colSum2[i] % 3) {
                    ok = false;
                }
            }

            if (ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}
