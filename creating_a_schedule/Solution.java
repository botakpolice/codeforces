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
            st = new StringTokenizer(br.readLine());
            int[] a = new int[m];
            for (int i = 0; i < m; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(a);
            int[][] ans = new int[n][6];
            for (int i = 0; i < n; i += 2) {
                if (i + 1 == n) {
                    for (int j = 0; j < 6; j++) {
                        if (j % 2 == 0) {
                            ans[i][j] = a[i / 2];
                        } else {
                            ans[i][j] = a[m - i / 2 - 1];
                        }
                    }
                } else {
                    for (int j = 0; j < 6; j++) {
                        if (j % 2 == 0) {
                            ans[i][j] = a[i / 2];
                            ans[i + 1][j] = a[m - i / 2 - 1];
                        } else {
                            ans[i][j] = a[m - i / 2 - 1];
                            ans[i + 1][j] = a[i / 2];
                        }
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < 6; j++) {
                    sb.append(ans[i][j]).append(" ");
                }
                System.out.println(sb.toString().trim());
            }


        }

    }
}
