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
            int ra = Integer.parseInt(st.nextToken());
            int ca = Integer.parseInt(st.nextToken());
            int rb = Integer.parseInt(st.nextToken());
            int cb = Integer.parseInt(st.nextToken());

            int ans = 0;
            if (ra < rb) {
                ans = Math.max(rb, ans);
            } else if (ra > rb) {
                ans = Math.max(n - rb, ans);
            }

            if (ca < cb) {
                ans = Math.max(ans, cb);
            } else if (ca > cb) {
                ans = Math.max(n - cb, ans);
            }

            System.out.println(ans);
        }

    }
}
