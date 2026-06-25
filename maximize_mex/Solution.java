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
            int x = Integer.parseInt(st.nextToken());

            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            HashMap<Long,Integer> ctr = new HashMap<>();
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
                ctr.put(a[i], ctr.getOrDefault(a[i], 0) + 1);
            }

            long ans = 0;
            while (true) {
                if (ctr.getOrDefault(ans, 0) == 0) {
                    break;
                } else {
                    ctr.put(ans + x, ctr.getOrDefault(ans + x,0) + ctr.get(ans) - 1);
                    ans++;
                }
            }

            System.out.println(ans);

        
        }

    }
}
