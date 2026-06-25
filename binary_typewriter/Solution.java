import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            char[] s = br.readLine().toCharArray();
            int cnt = 0;
            for (int i = 1; i < n; i++) {
                if (s[i - 1] != s[i]) {
                    cnt++;
                }
            }

            if (cnt == 0) {
                System.out.println(n + (s[0] == '1' ? 1 : 0));
            } else if (cnt == 1) {
                System.out.println(n + 1);
            } else {
                if (s[0] == '0' && cnt > 2) {
                    System.out.println(n + cnt - 2);
                } else {
                    System.out.println(n + cnt - 1);
                }
            }
        }

    }
}
