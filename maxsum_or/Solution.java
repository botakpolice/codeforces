import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int pow = 1;
            long ans = 0;
            // get to maximum bits first;
            while (pow < r) {
                pow = pow << 1 | 1;
            }

            Set<Integer> nums = new HashSet<>();
            for (int i = l; i <= r; i++) {
                nums.add(i);
            }

            int[] res = new int[r + 1];
            for (int i = r; i >= l; i--) {
                while (!nums.contains(pow - i)) {
                    pow >>= 1;
                }
                res[i] = pow - i;
                ans += i | res[i];
                nums.remove(pow - i);
            }

            System.out.println(ans);
            StringBuilder sb = new StringBuilder();
            for (int i = l; i <= r; i++) {
                sb.append(res[i]).append(" ");
            }

            System.out.println(sb.toString().trim());
        }

    }
}
