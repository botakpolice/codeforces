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
            int m = Integer.parseInt(st.nextToken());
            boolean[] a = new boolean[101];
            HashSet<Integer> c = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                a[x] = true;
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int x = Integer.parseInt(st.nextToken());
                if (a[x]) {
                    c.add(x);
                }
            }

            int ans = (Math.min(n, m) - c.size()) * 2;
            if (n <= m) {
                System.out.println(ans + 1);
            } else {
                System.out.println(ans + 2);
            }



        }

    }
}
