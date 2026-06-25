import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            HashMap<Triplet, Integer> ctr = new HashMap<>();

            long res = 0;
            for (int i = 0; i < n - 2; i++) {
                Triplet triplet = new Triplet(a[i], a[i + 1], a[i + 2]);

                Triplet[] valids = new Triplet[3];
                valids[0] = new Triplet(0,a[i + 1], a[i + 2]);
                valids[1] = new Triplet(a[i], 0, a[i + 2]);
                valids[2] = new Triplet(a[i], a[i + 1], 0);

                for (Triplet v : valids) {
                    res += ctr.getOrDefault(v, 0) - ctr.getOrDefault(triplet, 0);
                    ctr.put(v, ctr.getOrDefault(v, 0) + 1);
                }
                ctr.put(triplet, ctr.getOrDefault(triplet, 0) + 1);
            }

            System.out.println(res);
        }
    }


    static class Triplet {
        int x, y, z;
        public Triplet(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            } 
            if (!(o instanceof Triplet)) {
                return false;
            }

            Triplet other = (Triplet) o;

            return this.x == other.x 
                && this.y == other.y 
                && this.z == other.z;
        }

        @Override
        public int hashCode() {
            return x + 1000003 + y * 1009 + z;
        }


    }
}
