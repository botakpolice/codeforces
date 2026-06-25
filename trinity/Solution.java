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

            Arrays.sort(a);
            int l = 0, r = 2, res = n - 2;
            while (r < n) {

                // finding the largest valid window and then subtracting it from n to get the invalid numbers
                while (r - l >= 2 && a[l] + a[l + 1] <= a[r]) {
                    l++;
                }
                res = Math.min(res, n - (r - l + 1));
                r++;
            }

            System.out.println(res);
        }

    }
}
