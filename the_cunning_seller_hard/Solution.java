import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        
        long[] p = new long[21];
        p[0] = 1;
        for (int i = 1; i < 21; i++) {
            p[i] = p[i - 1] * 3;
        }

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            List<Integer> deals = new ArrayList<>();
            long min_k = 0;
            while (n > 0) {
                deals.add(n % 3);
                min_k += n % 3;
                n /= 3;
            }
            
            if (min_k > k) {
                System.out.println(-1);
                continue;
            }

            k -= min_k;
            
            // divide by 2 because each term diff is 1 to 3.

            for (int i = deals.size() - 1; i >= 1; i--) {
                if (deals.get(i) * 2 <= k) {
                    deals.set(i - 1, deals.get(i - 1) + 3 * deals.get(i));
                    k -= deals.get(i) * 2;
                    deals.set(i, 0);
                } else {
                    int splits = k / 2;
                    deals.set(i - 1, deals.get(i - 1) + splits * 3);
                    deals.set(i, deals.get(i) - splits);
                    break;
                }
            }
            long ans = 0;
            for (int i = 0; i < deals.size(); i++) {
                ans += deals.get(i) * fun(i, p);
            }

            System.out.println(ans);
        }


    }

    static long fun(int x, long[] p) {

        if (x - 1 >= 0) {
            return p[x + 1] + x * p[x - 1];
        } else {
            return p[x + 1];
        }
    }
}
