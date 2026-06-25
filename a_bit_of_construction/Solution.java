import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if (n == 1) {
                System.out.println(k);
            } else {
               
                int[] a = new int[n];
                int msb = 31 - Integer.numberOfLeadingZeros(k);
                a[0] = (1 << msb) - 1;
                a[1] = k - a[0];
                for (int i = 2; i < n; i++) {
                    a[i] = 0;
                }

                StringBuilder sb = new StringBuilder();
                for (int x : a) {
                    sb.append(x).append(" ");
                }

                System.out.println(sb.toString().trim());
            }
        }
    }

}
