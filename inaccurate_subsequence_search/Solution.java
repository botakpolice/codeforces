import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            HashMap<Integer,Integer> ctr = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int x = Integer.parseInt(st.nextToken());
                ctr.put(x, ctr.getOrDefault(x, 0) + 1);
            }

            int count = 0;
            for (int i = 0; i < m; i++) {
                int x = a[i];
                if (ctr.getOrDefault(x, 0) > 0) {
                    count++;
                }

                if (ctr.containsKey(x)) {
                    ctr.put(x, ctr.get(x) - 1);
                }
            }


            int res = 0;
            if (count >= k) {
                res++;
            }
            for (int l = 0, r = m; r < n; r++, l++) {
                int x = a[l];
                int y = a[r];
                if (ctr.containsKey(x)) {
                    ctr.put(x, ctr.getOrDefault(x, 0) + 1);
                    if (ctr.get(x) > 0) {
                        count--;
                    }
                }

                if (ctr.getOrDefault(y, 0) > 0) {
                    count++;
                }
                if (ctr.containsKey(y)) {
                    ctr.put(y, ctr.get(y) - 1);
                }

                if (count >= k) {
                    res++;
                }
            }

            System.out.println(res);
        }
    }

}
