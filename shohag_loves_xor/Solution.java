import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            long m = Long.parseLong(st.nextToken());

            int ans = 0;
            for (int y = 1; y <= Math.min(2 * x, m); y++) {
                if (y != x && ((y % (x ^ y) == 0) || (x % (x ^ y) == 0))) {
                    ans++;
                }
            }

            System.out.println(ans);
        }

    }
}
