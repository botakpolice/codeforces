import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            char[] s = br.readLine().toCharArray();
            char[] x = br.readLine().toCharArray();
            
            int i = 0, j = 0;
            if (x.length > s.length) {
                System.out.println("NO");
                continue;
            }
 
            boolean ok = false;
            while (i < s.length) {
                if (j == x.length) {
                    ok = true;
                    break;
                }
                if (s[i] == x[j] || s[i] == '?') {
                    s[i] = x[j];
                    j++;
                }
                i++;
            }

            ok = j == x.length;
            if (ok) {
                System.out.println("YES");
                for (int k = i; k < s.length; k++) {
                    if (s[k] == '?') {
                        s[k] = 'a';
                    }
                }

                System.out.println(new String(s));
            } else {
                System.out.println("NO");
            }
        }

    }
}
