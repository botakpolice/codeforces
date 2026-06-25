import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            int last = -1;
            int ans = n;
            for (int i = 0; i < n; i++) {
                if (a[i] != a[0]) {
                    ans = Math.min(ans, i - last - 1);
                    last = i;
                }
            }

            ans = Math.min(ans, n - last - 1);
            if (ans == n) {
                System.out.println(-1);
            } else {
                System.out.println(ans);
            }
        }
    }

}
