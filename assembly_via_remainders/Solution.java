import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int[] b = new int[n - 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n - 1; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            int[] a = new int[n];
            a[0] = 1000;
            for (int i = 1; i < n; i++) {
                a[i] = a[i - 1] + b[i - 1];
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(a[i]).append(" ");
            }

            System.out.println(sb.toString().trim());
        }
    }

}
