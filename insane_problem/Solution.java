import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());
            int l1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int l2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            int kn = 1;
            long ans = 0;
            for (int n = 0; r2/kn >= l1; n++) {
                // ceil of lowerbound , floor of upperbound
                // + 1 for counting itself
                ans += Math.max(0, Math.min(r2/kn, r1) - Math.max(l1, (l2 - 1)/kn + 1) + 1);
                kn *= k;
            }

            System.out.println(ans);
        }

    }
}
