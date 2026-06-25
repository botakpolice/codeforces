import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            boolean ok = true;
            int small = (int) (1e9);
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                if (x >= 2 * small) {
                    ok = false;
                }
                small = Math.min(small, x);
            }
            if (ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}
