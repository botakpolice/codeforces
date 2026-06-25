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
            int[] freq = new int[n + 1];
            int[] prefix = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                freq[x]++;
            }
            for (int i = 1; i <= n; i++) {
                prefix[i] = prefix[i - 1] + freq[i];
            }

            int ans = 1;
            for (int g = 1; g <= n; g++) {
                int x = Math.min(n, 4*g-1);
                // everything else > 4g is good;
                int good = n - prefix[x];
                if (g <= n) {
                    good += freq[g];
                }

                if (2 * g <= n) {
                    good += freq[2*g];
                }

                if (3 * g <= n) {
                    good += freq[3 * g];
                }

                if (good >= n - k) {
                    ans = g;
                }

            }

            System.out.println(ans);
        }
    }
}
