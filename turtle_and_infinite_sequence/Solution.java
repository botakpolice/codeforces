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

            if (m == 0) {
                System.out.println(n);
                continue;
            } else {

                long l = Math.max(0, n - m);
                long r = n + m;
                long res = 0;
                for (int i = 31; i >= 0; i--) {
                    if (((l & (1L << i)) != 0) ||
                        ((r & (1L << i)) != 0) ||
                        ((l >> (i + 1)) != (r >> (i + 1)))) {
                        res |= (1L << i);
                        }
                }
                System.out.println(res);
            }

        }

    }
}
