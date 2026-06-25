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
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (x == 0 && y == 0) {
                System.out.println(0);
            } else {

                int turnsX = (x + k - 1) / k;
                int turnsY = (y + k - 1) / k;
                int res = Math.max(2 * turnsX - 1, 2 * turnsY);
                System.out.println(res);
            }

        }

    }
}
