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
            char[][] a = new char[n][m];
            for (int i = 0; i < n; i++) {
                a[i] = br.readLine().toCharArray();
            }
            solve(a, n, m);

        }
    }

    static void solve(char[][] a, int n, int m) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == '0') {
                    continue;
                }

                boolean found = true;
                for (int k = 0; k < i; k++) {
                    if (a[k][j] == '0') {
                        found = false;
                        break;
                    }
                }

                if (found) {
                    continue;
                }

                found = true;
                for (int k = 0; k < j; k++) {
                    if (a[i][k] == '0') {
                        found = false;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println("YES");

    }
}
