import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            char[] a = br.readLine().toCharArray();
            char[] b = br.readLine().toCharArray();

            int cnt1 = 0;
            int cnt2 = 0;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    cnt1 += a[i] == '0' ? 1 : 0;
                    cnt2 += b[i] == '0' ? 1 : 0;
                } else {
                    cnt2 += a[i] == '0' ? 1 : 0;
                    cnt1 += b[i] == '0' ? 1 : 0;
                }
            }

            if (cnt1 >= (n + 1) / 2 && cnt2 >= n / 2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}
