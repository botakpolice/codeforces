import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int s = n * (n + 1) / 2;
            if (isq(s)) {
                System.out.println(-1);
                continue;
            }

            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = i + 1;
            }

            int j = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                while (j * j < i * (i + 1) / 2) {
                    j++;
                }
                if (j * j == (i * (i + 1)) / 2) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }

                sb.append(a[i]).append(" ");
            }

            System.out.println(sb.toString().trim());
        }

    }

    static boolean isq(int n) {
        int r = (int) Math.sqrt(n);
        return r * r == n;
    }
}
