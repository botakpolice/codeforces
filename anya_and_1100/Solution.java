import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            char[] s = br.readLine().toCharArray();
            int n = s.length;
            int cnt = 0;
            int q = Integer.parseInt(br.readLine());
            for (int i = 3; i < n; i++) {
                if (s[i - 3] == '1' && s[i - 2] == '1' && s[i - 1] == '0' && s[i] == '0') {
                    cnt++;
                }
            }

            for (int i = 0; i < q; i++) {
                st = new StringTokenizer(br.readLine());
                int j = Integer.parseInt(st.nextToken()) - 1;
                char c = (char) ('0' + Integer.parseInt(st.nextToken()));
                int before = is1100(s, j - 3) + is1100(s, j - 2) + is1100(s, j - 1) + is1100(s, j); 
                s[j] = c;
                int after = is1100(s,j - 3) + is1100(s,j - 2) + is1100(s,j - 1) + is1100(s,j);
                cnt = cnt + after - before;
                if (cnt > 0) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }


            }
        }
    }

    static int is1100(char[] s, int i) {
        if (i < 0) {
            return 0;
        }
        if (i + 3 >= s.length) {
            return 0;
        }

        if (s[i] == '1' && s[i + 1] == '1' && s[i + 2] == '0' && s[i + 3] == '0') {
            return 1;
        }

        return 0;
    }
}
