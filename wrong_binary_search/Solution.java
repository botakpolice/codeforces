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
            int l = 0;
            int[] p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i + 1;
            }

            boolean ok = true;
            while (l < n) {
                if (s[l] == '1') {
                    l++;
                    continue;
                }

                int r = l;
                while (r + 1 < n && s[r + 1] == '0') {
                    r++;
                }

                if (r - l + 1 == 1) {
                    ok = false;
                    break;
                }

                // cyclic rotation here
                for (int i = l; i < r; i++) {
                    p[i] = i + 2;
                }
                p[r] = l + 1;
                l = r + 1;
            }

            if (ok) {
                System.out.println("YES");
                StringBuilder sb = new StringBuilder();
                for (int x : p) {
                    sb.append(x).append(" ");
                }
                System.out.println(sb.toString().trim());
            } else {
                System.out.println("NO");
            }
        }

    }
}
