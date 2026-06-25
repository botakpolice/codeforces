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
            long x = Long.parseLong(st.nextToken());

            int[] a = new int[n];
            long sum = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                sum += a[i];
            }

            if (x > sum * k) {
                System.out.println(0);
                continue;
            }

            long rem = x % sum;
            long q = x / sum;
            if (rem == 0) {
                q--;
                rem = sum;
            }

            long ans = (long) n * k - q * n;
            long suf = 0;
            for (int i = n - 1; i >= 0; i--) {
                suf += a[i];
                if (suf >= rem) {
                    break;
                }
                ans--;
            }

            System.out.println(ans);
        }

    }
}
