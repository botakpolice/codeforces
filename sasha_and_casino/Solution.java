import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {

            st = new StringTokenizer(br.readLine());
            // k is multiplier
            // x is number of rounds till guaranteed win
            // a is the number of coins sasha has
            int k = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());

            if (a <= x) {
                System.out.println("NO");
                continue;
            }

            if (k > x + 1) {
                System.out.println("YES");
                continue;
            }

            long lost = 0;
            // x + 1 is guaranteed win
            boolean ok = true;
            for (int i = 0; i < x + 1; i++) {
                long bet = lost / (k - 1) + 1;
                lost += bet;

                if (lost > a) {
                    ok = false;
                }
            }

            if (ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

}
