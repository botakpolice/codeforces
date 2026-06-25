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
            int x = Integer.parseInt(st.nextToken()) - 1;
            char[] s = br.readLine().toCharArray();
            if (x == 0 || x == n - 1) {
                System.out.println(1);
                continue;
            }

            int inf = (int) (1e9);
            int left = -inf;
            int right = inf;
            for (int i = x - 1; i >= 0; i--) {
                if (s[i] == '#') {
                    left = i;
                    break;
                }
            }

            for (int i = x + 1; i < n; i++) {
                if (s[i] == '#') {
                    right = i;
                    break;
                }
            }

            if (left == -inf && right == inf) {
                System.out.println(1);
                continue;
            }

            // setting to right wall to Math.min(x + 1, n - right + 1);
            // or left wall = left + 2 because 0- indexed
            System.out.println(Math.max(Math.min(x + 1, n - right + 1), Math.min(left + 2, n - x)));

        }

    }
}
