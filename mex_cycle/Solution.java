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
            int y = Integer.parseInt(st.nextToken()) - 1;

            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                ans[(x + i) % n] = i % 2;
            }

            if (n % 2 == 1 || (x - y) % 2 == 0) {
                ans[x] = 2;
            }

            StringBuilder sb = new StringBuilder();
            for (int k : ans) {
                sb.append(k).append(" ");
            }

            System.out.println(sb.toString().trim());
        }

    }
}
