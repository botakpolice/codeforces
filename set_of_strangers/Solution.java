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

            boolean[] hasColor = new boolean[n * m + 1];
            boolean[] hasBad = new boolean[n * m + 1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int curr = a[i][j];
                    hasColor[curr] = true;
                    if (i + 1 < n && a[i + 1][j] == curr) {
                        hasBad[curr] = true;
                    }

                    if (j + 1 < m && a[i][j + 1] == curr) {
                        hasBad[curr] = true;
                    }

                }
            }

            int cntColor = 0;
            int cntBad = 0;

            for (int i = 0; i <= n * m; i++) {
                if (hasColor[i]) {
                    cntColor++;
                }
                if (hasBad[i]) {
                    cntBad++;
                }
            }

            System.out.println(cntColor + cntBad - 1 - (cntBad > 0 ? 1 : 0));

        }
    }

}
