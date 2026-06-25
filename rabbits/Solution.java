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
            boolean validSeg = s[0] == '1';
            int zeros = 0;
            boolean ok = true;
            for (int i = 0; i < n; i++) {
                if (s[i] == '0') {
                    zeros++;
                }

                if (i == 0) {
                    continue;
                }

                if (s[i] == s[i - 1] && s[i] == '0') {
                    validSeg = false;
                }

                if (s[i] == s[i - 1] && s[i] == '1') {
                    if (validSeg && zeros % 2 != 0) {
                        ok = false;
                    }
                    validSeg = true;
                    zeros = 0;
                }
            }

            if (validSeg && zeros % 2 == 1 && s[n - 1] == '1') {
                ok = false;
            }

            System.out.println(ok ? "YES" : "NO");
        }

    }
}
