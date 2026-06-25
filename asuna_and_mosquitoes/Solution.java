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
            long max = 0, sum = 0;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, a[i]);
                sum += a[i];
                if (a[i] % 2 != 0) {
                    cnt++;
                }

            }

            if (cnt == n || cnt == 0) {
                System.out.println(max);
            } else {
                System.out.println(sum - cnt + 1);
            }




        }

    }
}
