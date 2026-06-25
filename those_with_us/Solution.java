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
            int cnt_mx = 0;
            int mx = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(st.nextToken());
                    if (a[i][j] > mx) {
                        mx = a[i][j];
                        cnt_mx = 1;
                    } else if (a[i][j] == mx) {
                        cnt_mx++;
                    }
                }
            }

            int[] r = new int[n];
            int[] c = new int[m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (a[i][j] == mx) {
                        r[i]++;
                        c[j]++;
                    }
                }
            }

            int f = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (r[i] + c[j] - (a[i][j] == mx ? 1 : 0) == cnt_mx) {
                        f = 1;
                    }
                }
            }

            System.out.println(mx - f);
        }

    }
}
