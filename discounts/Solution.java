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

            st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            int[] b = new int[k];
            for (int i = 0; i < k; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(a);
            Arrays.sort(b);
            int d = 0;
            long res = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (d < k) {
                    if (b[d] > 1) {
                        res += a[i];
                        b[d]--;
                    } else {
                        d++;
                    }
                } else {
                    res += a[i];
                }
            }

            System.out.println(res);
        }

    }
}
