import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            String s = br.readLine();
            int l = 0, r = n - 1;
            long[] pre = new long[n + 1];
            pre[0] = 0;
            for (int i = 1; i <= n; i++) {
                pre[i] = pre[i - 1] + a[i - 1];
            }

            long res = 0;
            while (l < r) {
                char cl = s.charAt(l);
                char cr = s.charAt(r);

                if (cl == 'L' && cr == 'R') {
                    res += pre[r + 1] - pre[l];
                    l++;
                    r--;
                } else if (cl == 'L') {
                    r--;
                } else {
                    l++;
                }
            }

            System.out.println(res);
        }

    }
}
