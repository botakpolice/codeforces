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

            int[][] sum = new int[n][2];
            int[][] v = new int[n][m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int s = 0;
                for (int j = 0; j < m; j++) {
                    v[i][j] = Integer.parseInt(st.nextToken());
                    s += v[i][j];
                }

                sum[i] = new int[] {s, i};
            }

            Arrays.sort(sum, (a,b) -> b[0] - a[0]);
            int[][] v2 = new int[n][m];
            for (int i = 0; i < n; i++) {
                v2[i] = v[sum[i][1]];
            }

            long weight = n * m;
            long ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    ans += weight * v2[i][j];
                    weight--;
                }
            }

            System.out.println(ans);
        }

    }
}
