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
            long k = Long.parseLong(st.nextToken());
            long[] a = new long[n];
            long[] b = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
                b[i] = a[i];
            }
            if (a.length == 1) {
                System.out.println(a[0] + k);
                continue;
            }

            Arrays.sort(a);
            long min = -1;
            for (int i = 1; i < n; i++) {
                long diff = a[i] - a[i - 1];
                long req = diff * i;
                if (k >= req) {
                    k-= req;
                } else {
                    min = a[i - 1] + (k / i);
                    k -= (k / i) * i;
                    break;
                }
            }
            if (min == -1) {
                min = a[n - 1];
            }
            min += k / n;
            k = k % n;
            long res = min * n - n + 1 + k;
            for (int i = 0; i < n; i++) {
                if (b[i] > min) {
                    res++;
                }
            }
            System.out.println(res);
        }
    }

}
