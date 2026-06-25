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
            int q = Integer.parseInt(st.nextToken());

            TreeSet<Integer> ts = new TreeSet<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int x = Integer.parseInt(st.nextToken());
                ts.add(x);
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < q; i++) {
                int x = Integer.parseInt(st.nextToken());
                Integer lo = ts.floor(x);
                Integer hi = ts.ceiling(x);

                if (lo != null && hi != null) {
                    int distL = x - lo;
                    int distR = hi - x;
                    System.out.println(Math.abs(distL - distR) / 2 + Math.min(distL, distR));
                } else {
                    if (lo == null) {
                        System.out.println(hi - 1);
                    } else {
                        System.out.println(n - lo);
                    }
                }
            }
        }

    }
}
