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
            char[] r = br.readLine().toCharArray();

            int cnt0 = 0;
            for (int i = 0; i < n; i++) {
                if (s[i] == '0') {
                    cnt0++;
                }
            }

            int cnt1 = n - cnt0;
            boolean ok = true;
            for (int i = 0; i < r.length; i++) {
                if (cnt1 == 0 || cnt0 == 0) {
                    ok = false;
                    break;
                }

                if (r[i] == '1') {
                    cnt0--;
                } else {
                    cnt1--;
                }
            }

            if (ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}
