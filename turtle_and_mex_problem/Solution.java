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
            HashSet<Integer>[] a = new HashSet[n];
            int y = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken());
                HashSet<Integer> b = new HashSet<>();
                for (int j = 0; j < l; j++) {
                    int x = Integer.parseInt(st.nextToken());
                    b.add(x);
                }
                a[i] = b;
                int x = 0;
                while (b.contains(x)) {
                    x++;
                }
                y = Math.max(y, x);
            }

            int k = 0;
            for (int i = 0; i < n; i++) {
                HashSet<Integer> b = a[i];
                int x = 0;
                boolean used = false;
                while (true) {
                    if (b.contains(x)) {
                        x++;
                    } else {
                        if (!used && x <= y) {
                            used = true;
                            x++;
                        } else {
                            break;
                        }
                    }
                }

                k = Math.max(k, x);
            }


            // k = 3 , 50 - 3 * (50 + 4) / 2
            long s = 0;
            if (k < m) {
                s = (long) (m - k) * (m + k + 1) / 2;
            }
            long res = (long) k * (Math.min(m,k) + 1) + s;

            System.out.println(res);
        }

    }
}
