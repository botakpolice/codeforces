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
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int[][] rects = new int[][] {
                {a, m},
                {n - a + 1, m},
                {n, b},
                {n, m - b + 1}
            };

            int ans = n + m;
            for (int[] r : rects) {

                int res = 0;
                
                while (r[0] > 1) {
                    res++;
                    r[0] = (r[0] + 1) / 2;
                }

                while (r[1] > 1) {
                    res++;
                    r[1] = (r[1] + 1) / 2;
                }

                ans = Math.min(ans, res);
            }

            System.out.println(1 + ans);

        }

    }
}
