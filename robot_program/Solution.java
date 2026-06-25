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
            int x = Integer.parseInt(st.nextToken());
            long k = Long.parseLong(st.nextToken());
            char[] s = br.readLine().toCharArray();
            for (int i = 0; i < n; i++) {
                if (s[i] == 'L') {
                    x--;
                } else {
                    x++;
                }
                k--;
                if (x == 0) {
                    break;
                }
            }

            if (x == 0) {
                long ans = 1;

                for (int i = 0; i < n; i++) {
                    if (s[i] == 'L') {
                        x--;
                    } else {
                        x++;
                    }

                    if (x == 0) {
                        ans += k / (i + 1); 
                        break;
                    }
                }

                System.out.println(ans);
            } else {
                System.out.println(0);
            }
        }

    }
}
