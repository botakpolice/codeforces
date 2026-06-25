import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // we take sum of 1s at top
            // then sum of 1s at bottom
            // take the max of the two, then - all -1s that we have to take

            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            int[] b = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            int x = 0, y = 0, c = 0, d = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] == 1 && b[i] == 1) {
                    c++;
                } else if (a[i] == 1) {
                    x++;
                } else if (b[i] == 1) {
                    y++;
                }

                if (a[i] == -1 && b[i] == -1) {
                    d++;
                }
            }
            // if both 1, we give the lowest one with a new 1
            // if both -1, we give the highest one with a new -1

            while (c > 0) {
                if (x >= y) {
                    y++;
                } else {
                    x++;
                }
                c--;
            }

            while (d > 0) {
                if (x >= y) {
                    x--;
                } else {
                    y--;
                }
                d--;
            }

            int res = Math.min(x, y);
            System.out.println(res);

        }

    }
}
