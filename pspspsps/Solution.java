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
            if (s[0] == 's') {
                s[0] = '.';
            } 

            if (s[n - 1] == 'p') {
                s[n - 1] = '.';
            }

            boolean found_p = false;
            boolean found_s = false;
            for (int i = 0; i < n; i++) {
                if (s[i] == 'p') {
                    found_p = true;
                }

                if (s[i] == 's') {
                    found_s = true;
                }
            }

            if (found_s && found_p) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }

    }
}
