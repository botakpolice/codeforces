import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {

            // (a[i] + a[j]) % x == 0
            // (a[i] - a[j]) % y == 0
            // a[i] % x + a[j] % x == 0
            // a[i] % x == x -a[k] % x
            // a[i] % y - a[j] % y == 0
            // a[i] % y == a[j] % y

            HashMap<Pair,Integer> ctr = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            long res = 0;
            // 10 : [0, 4]
            // 7 : [2, 1], [3, 1]
            // 6 : [1, 0], [4, 0]
            // 7 : [2, 1], [3, 1]
            // 9 : [4, 3], [1, 3]
            // 7 : [2, 1], [3, 1]
            // 7 : [2, 1], [3, 1]
            // 10 :[0, 4], [0, 4]
            // 10 :[0, 4], [0, 4]
            for (int i = 0; i < n; i++) {
                int xx = a[i] % x;
                int lookFor1 = (x - xx) % x;
                int yy = a[i] % y;
                Pair p = new Pair(lookFor1, yy);
                res += ctr.getOrDefault(p, 0);
                Pair p2 = new Pair(xx, yy);
                ctr.put(p2, ctr.getOrDefault(p2,0) + 1);
            }

            System.out.println(res);
        }
    }

    static class Pair {
        int j, k;

        public Pair(int j, int k) {
            this.j = j;
            this.k = k;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }

            if (o == null || !(o instanceof Pair)) {
                return false;
            }

            Pair oth = (Pair) o;
            return this.j == oth.j && this.k == oth.k;
        }

        @Override
        public int hashCode() {
            return 31 * j + k;
        }
        
    }
}
