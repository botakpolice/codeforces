import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int[] pre = new int[n];
            int[] suf = new int[n];
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            pre[0] = a[0];
            suf[n - 1] = a[n - 1];
            for (int i = 1; i < n; i++) {
                pre[i] = Math.min(pre[i - 1], a[i]);
            }

            for (int i = n - 2; i >= 0; i--) {
                suf[i] = Math.max(suf[i + 1], a[i]);
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (a[i] == suf[i] || a[i] == pre[i]) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
            }

            System.out.println(sb.toString().trim());
            
        }

    }
}
