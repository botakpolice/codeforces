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
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            int[] a = new int[n];
            Arrays.fill(a, 1);
            int k = -1;
            for (int i = x + 1; i < n; i++) {
                a[i] = k;
                k *= -1;
            }

            k = -1;
            for (int i = y - 1; i >= 0; i--) {
                a[i] = k;
                k *= -1;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(a[i]).append(" ");
            }

            System.out.println(sb.toString().trim());

        }

    }
}
