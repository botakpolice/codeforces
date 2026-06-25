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

            int[] ctr = new int[n + 1];
            int[] a  = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                a[i] = x;
                ctr[a[i]]++;
            }

            boolean ok = true;
            for (int i = 0; i <= n; i++) {
                if (ctr[i] % k != 0) {
                    ok = false;
                    break;
                } else {
                    ctr[i] /= k;
                }
            }

            if (ok) {
                long res = 0;
                int[] cnt2 = new int[n + 1];
                for (int l = 0, r = 0; r < n; r ++) {
                    cnt2[a[r]]++;
                    while (l < r && cnt2[a[r]] > ctr[a[r]]) {
                        cnt2[a[l]]--;
                        l++;
                    }

                    res += r - l + 1;
                }

                System.out.println(res);
            } else {
                System.out.println(0);
            }


        }

    }
}
