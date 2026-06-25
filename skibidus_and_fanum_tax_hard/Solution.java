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
            int[] a = new int[n];
            TreeSet<Integer> b = new TreeSet<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                b.add(Integer.parseInt(st.nextToken()));
            }

            boolean ok = true;
            a[0] = Math.min(a[0], b.ceiling(Integer.MIN_VALUE + a[0]) - a[0]);
            for (int i = 1; i < n; i++) {
                Integer minElem = b.ceiling(a[i - 1] + a[i]);

                if (minElem != null) {
                    if (a[i] < a[i - 1]) {
                        // set the max if a[i] < a[i - 1]
                        a[i] = minElem - a[i];
                    } else {
                        // set the min of both
                        a[i] = Math.min(a[i], minElem - a[i]);
                    }
                }

                if (a[i] < a[i - 1]) {
                    ok = false;
                    break;
                }

            }

            if (ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }

    }
}
