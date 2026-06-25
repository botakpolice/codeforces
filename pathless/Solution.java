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
            int s = Integer.parseInt(st.nextToken());

            int sum = 0;
            int[] a = new int[3];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                a[x]++;
                sum += x;
            }

            if (sum == s || s - sum >= 2) {
                System.out.println(-1);
            } else {

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < a[0]; i++) {
                    sb.append(0).append(" ");
                }
                for (int i = 0; i < a[2]; i++) {
                    sb.append(2).append(" ");
                }
                for (int i = 0; i < a[1]; i++) {
                    sb.append(1).append(" ");
                }
                System.out.println(sb.toString().trim());
            }
        }



    }

}
