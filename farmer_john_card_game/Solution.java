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

            solve(a, n, m);

        }

    }

    static void solve(int[][] a, int n, int m) {

        List<int[]> p = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Arrays.sort(a[i]);
            for (int j = 1; j < m; j++) {
                if (a[i][j] - a[i][j - 1] != n) {
                    System.out.println(-1);
                    return;
                }
            }
            p.add(new int[]{a[i][0], i + 1});
        }

        p.sort((x,y) -> x[0] - y[0]);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(p.get(i)[1]).append(" ");
        }

        System.out.println(sb.toString().trim());


    }
}
