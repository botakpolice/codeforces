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
            int k = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            if (k % 2 == 1) {
                for (int i = 0; i < n; i++) {
                    a[i] = n;
                }
                a[n - 1] = n - 1;
            } else {
                for (int i = 0; i < n; i++) {
                    a[i] = n - 1;
                }

                a[n - 2] = n;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(a[i]).append(" ");
            }

            System.out.println(sb.toString().trim());

        }

    }
}
