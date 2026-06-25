import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] p = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                p[i] = Integer.parseInt(st.nextToken());
            }

            Set<Integer> set = new HashSet<>();
            st = new StringTokenizer(br.readLine());

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                int d = Integer.parseInt(st.nextToken()) - 1;

                while (!set.contains(d)) {
                    set.add(d);
                    d = p[d] - 1;
                }
                sb.append(set.size()).append(" ");
            }

            System.out.println(sb.toString().trim());
        }

    }
}
