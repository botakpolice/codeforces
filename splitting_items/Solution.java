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
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            int sum = 0;
            Arrays.sort(a);
            for (int i = n - 1; i >= 0; i-=2) {
                int first = a[i];
                sum += first;
                if (i > 0) {
                    int second = a[i - 1];
                    if (k > 0) {
                        a[i - 1] = Math.min(a[i], a[i - 1] + k);
                        k -= (a[i - 1] - second);
                    }
                    sum -= a[i - 1];
                }
            }

            System.out.println(sum);
        }

    }
}
