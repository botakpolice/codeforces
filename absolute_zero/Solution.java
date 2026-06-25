import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());

            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            boolean odd = false;
            boolean even = false;
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                if (a[i] % 2 == 0) {
                    even = true;
                } else {
                    odd = true;
                }
            }

            if (odd && even) {
                System.out.println(-1);
                continue;
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 29; i >= 0; i--) {
                    sb.append(1 << i).append(" ");
                }

                if (even) {
                    sb.append(1);
                }

                if (even) {
                    System.out.println(31);
                } else {
                    System.out.println(30);
                }
                System.out.println(sb.toString().trim());
            }
        }

    }
}
