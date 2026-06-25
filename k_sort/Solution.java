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
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            long res = 0;
            long times = 0;
            for (int i = 1; i < n; i++) {
                if (a[i] < a[i - 1]) {
                    res += a[i - 1] - a[i];
                    times = Math.max(times, a[i - 1] - a[i]);
                    a[i] = a[i - 1];
                }
            }


            System.out.println(res + times);
        }

    }
}
