import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            List<int[]> pairs = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int[] a = new int[2];
                for (int j = 0; j < 2; j++) {
                    a[j] = Integer.parseInt(st.nextToken());
                }

                pairs.add(a);
            }

            pairs.sort((a,b) -> {
                int minLeft = Math.min(a[0], a[1]);
                int minRight = Math.min(b[0], b[1]);
                int maxLeft = Math.max(a[0], a[1]);
                int maxRight = Math.max(b[0], b[1]);

                if (minLeft == minRight) {
                    return maxLeft - maxRight;
                } else {
                    return minLeft - minRight;
                }
            });

            StringBuilder sb = new StringBuilder();
            for (int[] p : pairs) {
                for (int x : p) {
                    sb.append(x).append(" ");
                }
            }

            System.out.println(sb.toString().trim());
        }

    }
}
