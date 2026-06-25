import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            char[] s = br.readLine().toCharArray();
            int sum = 0;
            int cnt2 = 0;
            int cnt3 = 0;
            int n = s.length;
            
            for (int i = 0; i < n; i++) {
                sum += s[i] - '0';
                if (s[i] == '2') {
                    cnt2++;
                }

                if (s[i] == '3') {
                    cnt3++;
                }
            }

            boolean ok = false;
            for (int i = 0; i <= Math.min(cnt2, 10); i++) {
                for (int j = 0; j <= Math.min(cnt3, 10); j++) {
                    if ((sum + 2 * i + 6 * j) % 9 == 0){
                        ok = true;
                        break;
                    }
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
