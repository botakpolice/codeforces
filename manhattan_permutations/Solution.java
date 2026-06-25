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
            long k = Long.parseLong(st.nextToken());

            long mx = (long) n * n / 2;
            if (k % 2 == 1 || k > mx) {
                System.out.println("No");
                continue;
            }

            int[] a = new int[n + 1];
            int l = 1, r = n;

            while (l <= r) {
                if (k >= 2 * (r - l)) {
                    k -= 2 * (r - l);
                    a[l] = r;
                    a[r] = l;
                    l++;
                    r--;
                } else {
                    a[r] = r;
                    r--;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                sb.append(a[i]).append(" ");
            }

            System.out.println("Yes");
            System.out.println(sb.toString().trim());


        }

    }
}
