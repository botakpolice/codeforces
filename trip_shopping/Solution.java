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
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            long ans = 0;
            List<Pair> al = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int b = Integer.parseInt(st.nextToken());
                ans += Math.abs(b - a[i]);
                if (b < a[i]) {
                    al.add(new Pair(b, a[i]));
                } else {
                    al.add(new Pair(a[i], b));
                }
            }

            al.sort(null);
            boolean ok = true;
            for (int i = 1; i < n; i++) {
                if (al.get(i).x <= al.get(i - 1).y) {
                    ok = false;
                    break;
                }
            }
            if (!ok) {
                System.out.println(ans);
            } else {
                int min = (int) (1e9);
                for (int i = 1; i < n; i++) {
                    min = Math.min(min, al.get(i).x - al.get(i - 1).y);
                }

                System.out.println(ans + 2 * min);
            }

        }

    }

    static class Pair implements Comparable<Pair> {
        int x,y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair oth) {
            if (this.x == oth.x) {
                return this.y - oth.y;
            } else {
                return this.x - oth.x;
            }
        }
    }
}
