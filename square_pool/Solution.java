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
            int s = Integer.parseInt(st.nextToken());

            int res = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int dx = Integer.parseInt(st.nextToken());
                int dy = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if (dx == dy) {
                    res += (x == y ? 1 : 0);
                } else {
                    res += (x + y == s ? 1 : 0);
                }
            }
            System.out.println(res);
        }

    }
}
