import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());

            char[] top = br.readLine().toCharArray();
            char[] bot = br.readLine().toCharArray();

            int R = n - 1;
            for (int i = 0; i < n - 1; i++) {
                if (top[i + 1] > bot[i]) {
                    R = i;
                    break;
                }
            }

            int L = R;
            for (int i = R - 1; i >= 0; i--) {
                if (top[i + 1] == bot[i]) {
                    L = i;
                } else{
                    break;
                }
            }

            StringBuilder smallestString = new StringBuilder();
            for (int i = 0; i <= R; i++) {
                smallestString.append(top[i]);
            }

            for (int i = R; i < n; i++) {
                smallestString.append(bot[i]);
            }

            int ways = R - L + 1;
            System.out.println(smallestString);
            System.out.println(ways);

        }
    }

}
