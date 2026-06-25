import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            char[] s = br.readLine().toCharArray();
            if (s[0] != '1') {
                System.out.println("NO");
            } else {
                int n = s.length;
                if (s[n - 1] == '9') {
                    System.out.println("NO");
                    continue;
                }

                boolean ok = true;
                for (int i = 1; i < n - 1; i++) {
                    if (s[i] == '0') {
                        ok = false;
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
}
