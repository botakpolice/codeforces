import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            int[] b = new int[n];


            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                a[i] = x;
                b[i] = y;
            }

            boolean[] dont_take = new boolean[n];
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        continue;
                    }

                    if (a[j] <= a[i] && b[i] <= b[j]) {
                        dont_take[i] = true;
                    }
                }

                if (!dont_take[i]) {
                    res.add(i + 1);
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int x : res) {
                sb.append(x).append(" ");
            }
            System.out.println(res.size());
            System.out.println(sb.toString().trim());
        }

    }
}
