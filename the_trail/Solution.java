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
            char[] s = br.readLine().toCharArray();

            long[][] a = new long[n][m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    a[i][j] = Long.parseLong(st.nextToken());
                }
            }

            int x = 0, y = 0;
            for (int i = 0; i <= s.length; i++) {
                if (i == s.length) {

                    long sum = 0;
                    for (int j = 0; j < n; j++) {
                        sum += a[j][m - 1];
                    }
                    a[n - 1][m - 1] = -sum;
                    continue;

                }
                if (s[i] == 'D') {
                    long sum = 0;
                    for (int j = 0; j < m; j++) {
                        sum += a[x][j]; 
                    }

                    a[x][y] = -sum;
                    x++;
                } else {
                    long sum = 0;
                    for (int j = 0; j < n; j++) {
                        sum += a[j][y];
                    }

                    a[x][y] = -sum;
                    y++;
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
