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
            int d = Integer.parseInt(st.nextToken());

            List<Integer> ans = new ArrayList<>();
            ans.add(1);

            if (d % 3 == 0 || n >= 3) {
                ans.add(3);
            }

            if (d == 5) {
                ans.add(5);
            }

            if (d == 7 || n >= 3) {
                ans.add(7);
            }

            if (d == 9 || n >= 6 || (n >= 3 && d % 3 == 0)) {
                ans.add(9);
            }

            StringBuilder sb = new StringBuilder();
            for (int x : ans) {
                sb.append(x).append(" ");
            }

            System.out.println(sb.toString().trim());
        }

    }
}
