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

            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            HashMap<Integer,Integer> ctr = new HashMap<>();
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                ctr.put(a[i], ctr.getOrDefault(a[i], 0) + 1);
            }

            List<Integer> vals = new ArrayList<>(ctr.values());
            vals.sort(null);
            int res = 0;
            for (int v : vals) {
                if (v <= k) {
                    k -= v;
                } else {
                    res++;
                }
            }

            System.out.println(Math.max(res, 1));


        }

    }
}
