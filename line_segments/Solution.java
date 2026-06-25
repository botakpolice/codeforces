import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            double[] a = new double[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Double.parseDouble(st.nextToken());
            }

            a[n] = Math.sqrt((double) (sx - ex) * (sx - ex) + (double) (sy - ey) * (sy - ey));
            Arrays.sort(a);
            double sum = a[n];
            for (int i = 0; i < n; i++) {
                sum -= a[i];
            }

            if (sum <= 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}
