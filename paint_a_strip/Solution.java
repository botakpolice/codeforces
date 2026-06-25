import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int ans = 1;
            int curr = 1;
            while (true) {

                if (curr >= n) {
                    System.out.println(ans);
                    break;
                }
                ans += 1;
                curr = curr * 2 + 2;
            }
        }

    }
}
