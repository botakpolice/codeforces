import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            boolean[] removed = new boolean[n];
            char[] s = br.readLine().toCharArray();
            int a = 0;
            int b = 0;
            int c = 0;
            for (int i = 0; i < k; i++) {
                if (s[i] == '2') {
                    c++;
                } else if (s[i] == '1') {
                    b++;
                } else {
                    a++;
                }
            }

            char[] res = new char[n];
            for (int i = 0; i < n; i++) {
                res[i] = '+';
            }
            for (int i = 0; i < n; i++) {
                if (i < a + c || i > n - 1 - b - c) {
                    res[i] = '?';
                }

                if (i < a || i > n - 1 - b || k == n) {
                    res[i] = '-';
                } 
            }

            System.out.println(new String(res));
        }

    }
}
