import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            // 2 2 3 3 3 4 4 4 5 5
            // sliding window
            // k = 2
            // 2 2 3 3 3 -> 5
            // 3 3 3 4 4 4 -> 6 
            // 4 4 4 5 5 -> 5
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            HashMap<Integer,Integer> ctr = new HashMap<>();
            int res = 0;
            Arrays.sort(a);
            for (int l = 0, r = 0; r < n; r++) {
                if (r > 0 && a[r] - a[r - 1] > 1) {
                    ctr = new HashMap<>();
                    l = r;
                }
                ctr.put(a[r], ctr.getOrDefault(a[r] , 0) + 1);
                while(ctr.size() > k) {
                    if (ctr.get(a[l]) == 1) {
                        ctr.remove(a[l]);
                    } else {
                        ctr.put(a[l], ctr.get(a[l]) - 1);
                    }
                    l++;
                }

                res = Math.max(res, r - l + 1);

            }

            System.out.println(res);
        }

    }
}
