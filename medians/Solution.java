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
            int k = Integer.parseInt(st.nextToken());

            if (k == 1 && n == 1) {
                System.out.println(1);
                System.out.println(1);
                continue;
            }

            if (k == 1 || k == n) {
                System.out.println(-1);
                continue;
            }

            StringBuilder sb = new StringBuilder();
            int parts = 0;
            if (k > (n + 1) / 2) {
                parts = n - k;
            } else {
                parts = k - 1;
            }

            for (int i = 1; i <= parts; i++) {
                sb.append(i).append(" ");
            }
            sb.append(k).append(" ");
            for (int i = k + 1; i <= k + parts; i++) {
                sb.append(i).append(" ");
            }

            System.out.println(parts * 2 + 1);
            System.out.println(sb.toString().trim());

        }

    }
}
