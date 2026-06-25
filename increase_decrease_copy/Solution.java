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

            int[] b = new int[n+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n + 1; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            long res = 0;
            int additions = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int min = Math.min(a[i], b[i]);
                int max = Math.max(a[i], b[i]);
                if (b[n] >= min && b[n] <= max) {
                    additions = 1;
                } else {
                    additions = Math.min(additions, Math.min(Math.abs(a[i] - b[n]), Math.abs(b[i] - b[n])) + 1);
                }
                res += Math.abs(a[i] - b[i]);
            }

            res += additions;

            System.out.println(res);
        }
    }

}
