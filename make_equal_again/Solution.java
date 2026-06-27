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

            int x = a[0];
            int y = a[n - 1];
            int xx = 0;
            int yy = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] != x) {
                    break;
                } else {
                    xx++;
                }
            }

            for (int i = n - 1; i >= 0; i--) {
                if (a[i] != y) {
                    break;
                } else {
                    yy++;
                }
            }

            if (x == y) {
                System.out.println(Math.max(0,n - xx - yy));
            } else {
                System.out.println(Math.max(0,Math.min(n - xx, n - yy)));
            }

            

        }
    }

}
