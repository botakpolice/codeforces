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
            int q = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            long[] a = new long[n];
            HashMap<Long,Long> mp = new HashMap<>();
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }

            for (int i = 0; i < n; i++) {

                long temp = (long) (i + 1) * (n - i) - 1;
                mp.put(temp, mp.getOrDefault(temp, 0L) + 1);

                if (i > 0) {
                    long temp2 = (long) i * (n - i);
                    mp.put(temp2, mp.getOrDefault(temp2, 0L) + a[i] - a[i - 1] - 1);
                }
            }

            st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < q; i++) {
                long x = Long.parseLong(st.nextToken());
                if (mp.get(x) == null) {
                    sb.append(0);
                } else {
                    sb.append(mp.get(x));
                }

                sb.append(" ");
            }


            System.out.println(sb.toString().trim());
        }

    }
}
