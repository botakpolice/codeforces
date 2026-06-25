import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int ans = -1;
            int x = Integer.parseInt(br.readLine());
            for (int i = 0; i < 30; i++) {
                boolean ok = false;
                if (ok) {
                    break;
                }
                for (int j = 0; j < 30; j++) {
                    int y = (1 << i) | (1 << j);
                    if (y < x && x + y > (x ^ y) && y + (x ^ y) > x) {
                        ans = y;
                        ok = true;
                        break;
                    }
                }
            }

            System.out.println(ans);
        }

    }
}
