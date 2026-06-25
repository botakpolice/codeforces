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
            int k = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(br.readLine());
            int[] h = new int[w];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < w; i++) {
                h[i] = Integer.parseInt(st.nextToken());
            }


            long[] contri = new long[n * m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    long r1 = Math.max(0, i - k + 1);
                    long r2 = Math.min(i, n - k);

                    long c1 = Math.max(0, j - k + 1);
                    long c2 = Math.min(j, m - k);

                    contri[i * m + j] = (r2 - r1 + 1) * (c2 - c1 + 1);
                }
            }
            Arrays.sort(contri);
            Arrays.sort(h);
            int i = n * m - 1;
            int j = w - 1;
            long res = 0;
            while (j >= 0) {
                res += contri[i--] * h[j--];
            }

            System.out.println(res);

        }

    }
}
