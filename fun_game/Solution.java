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
            char[] ss = br.readLine().toCharArray();

            int i = 0;
            boolean ok = true;
            while (i < s.length && s[i] == '0') {
                if (ss[i] != '0') {
                    ok = false;
                    break;
                }
                i++;
            }

            if (ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }

    }
}
