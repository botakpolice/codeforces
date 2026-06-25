import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] pairs = new int[n][2];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                pairs[i] = new int[] {x , y};
            }

            HashMap<Integer,Integer> ctr = new HashMap<>();

            for (int[] p : pairs) {
                ctr.put(p[0], ctr.getOrDefault(p[0], 0) + 1);
            }

            long res = 0;
            for (int k : ctr.keySet()) {
                if (ctr.get(k) == 2) {
                    res += n - 2;
                }
            }

            HashSet<String> set = new HashSet<>();
            for (int[] p : pairs) {
                set.add(p[0] + ":" + p[1]);
            }

            for (int[] p : pairs) {
                String left = (p[0] - 1) + ":" + (1 - p[1]);
                String right = (p[0] + 1) + ":" + (1 - p[1]);

                if (set.contains(left) && set.contains(right)) {
                    res++;
                }
            }

            System.out.println(res);

        }

    }
}
