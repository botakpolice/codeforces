import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            int[] v = new int[n];
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    v[i] = 1;
                }
            }

            boolean ok = false;
            if ((v[0] | v[n - 1]) == 1) {
                ok = true;
            }

            for (int i = 1; i < n; i++) {
                if ((v[i] & v[i - 1]) == 1) {
                    ok = true;
                    break;
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
