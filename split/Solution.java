import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] ctr = new int[2 * n];
            st = new StringTokenizer(br.readLine());
            // needs to keep both subsequences p and q of same len
            for (int i = 0; i < 2*n; i++) {
                int x = Integer.parseInt(st.nextToken()) - 1;
                ctr[x]++;
            }

            long x = 0, y = 0, z = 0;
            for (int i = 0; i < 2 * n; i++) {
                if (ctr[i] > 0) {
                    // if odd, 1 contribution
                    if (ctr[i] % 2 == 1) {
                        x++;
                        // if % 4 == 2
                        // cannot be 1 since it wouldve been accounted for as odd
                    } else if (ctr[i] % 4 > 0) {
                        y++;
                    } else {
                        z++;
                    }
                }
            }

            long res = x + y * 2 + z * 2;
            if (z % 2 == 1 && x == 0) {
                System.out.println(res - 2);
            } else {
                System.out.println(res);
            }
        }
    }
}
