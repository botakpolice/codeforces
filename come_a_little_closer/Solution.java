import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int[][] x = new int[n][2];
            int[][] y = new int[n][2];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                x[i][0] = x1;
                y[i][0] = y1;
                x[i][1] = y[i][1] = i;
            }

            Arrays.sort(x, (a,b) -> a[0] - b[0]);
            Arrays.sort(y, (a,b) -> a[0] - b[0]);

            long ans = rect(x[0][0], x[n - 1][0], y[0][0], y[n - 1][0],n);
            if (n == 1) {
                System.out.println(ans);
                continue;
            }

            int[] points = new int[]{x[0][1], x[n - 1][1], y[0][1], y[n-1][1]};
            for (int p : points) {
                int minx = x[0][1] == p ? x[1][0] : x[0][0];
                int maxx = x[n-1][1] == p ? x[n-2][0] : x[n-1][0];
                int miny = y[0][1] == p ? y[1][0] : y[0][0];
                int maxy = y[n-1][1] == p ? y[n-2][0] : y[n-1][0];
                ans = Math.min(ans, rect(minx,maxx,miny,maxy,n));
            }

            System.out.println(ans);
        }
    }

    static long rect(int x1, int x2, int y1, int y2, int n) {
        long h = x2 - x1 + 1;
        long w = y2 - y1 + 1;
        if (h * w < n) {
            return Math.min((h + 1) * w, h * (w + 1));
        }

        return h * w;

    }
}
