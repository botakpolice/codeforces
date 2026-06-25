import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(a[i], - 1);
            }
            f(0,0,n,n * n - 1, a);

            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(a[i][j]).append(" ");
                }
                System.out.println(sb.toString().trim());
            }
        }
    }

    static void f(int r, int c, int n, int val, int[][] a) {
        if (r == n || c == n || r < 0 || c < 0 || a[r][c] != -1) {
            return;
        }

        a[r][c] = val--;
        while (c + 1 < n && a[r][c + 1] == -1) {
            a[r][++c] = val--;
        }
        
        while (r + 1 < n && a[r + 1][c] == -1) {
            a[++r][c] = val--;
        }

        while (c - 1 >= 0 && a[r][c-1] == -1) {
            a[r][--c] = val--;
        }

        while (r - 1 >= 0 && a[r - 1][c] == -1) {
            a[--r][c] = val--;
        }

        f(r,c + 1, n, val, a);

    }
}
