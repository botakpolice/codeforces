import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] s = br.readLine().split(" ");
            String l = s[0], r = s[1];
            if (l.equals(r)) {
                System.out.println(2 * l.length());
                continue;
            }

            int ptr = 0;
            // both l and r have same length
            while (ptr < l.length() && l.charAt(ptr) == r.charAt(ptr)) {
                ptr++;
            }

            if (l.charAt(ptr) + 1 < r.charAt(ptr)) {
                System.out.println(2 * ptr);
            } else {
                int res = 2 * ptr + 1;
                for (int i = ptr + 1; i < l.length(); i++) {
                    if (l.charAt(i) == '9' && r.charAt(i) == '0') {
                        res++;
                    } else {
                        break;
                    }
                }
                System.out.println(res);
            }
        }

    }
}
