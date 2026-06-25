import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        long[] c = new long[501];
        for (int i = 1; i <= 500; i++) {
            c[i] = c2(i);
        }

        System.out.println(Arrays.toString(c));
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            List<int[]> res = new ArrayList<>();
            int x = 1, y = 1;
            if (k == 0) {
                System.out.println(1);
                System.out.println("1 1");
            } else {
                while (k > 0) {
                    int k1 = lowerBound(c, k);
                    for (int i = 1; i <= k1; i++) {
                        res.add(new int[]{x,y++});
                    }

                    k -= c2(k1);
                    x++;
                }
                System.out.println(res.size());
                for (int[] p : res) {
                    System.out.println(p[0] + " " + p[1]);
                }

            }

        }

    }

    static int lowerBound(long[] c, long target) {

        int lo = 0, hi = c.length;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (c[mid] <= target) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }

    static long c2(int n) {

        return (long) n * (n - 1) / 2;
    }
}
