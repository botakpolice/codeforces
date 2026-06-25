import java.io.*;
import java.util.*;

public class cyclic_merging {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int m = 0;
            int[] a = new int[n + 1];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                if (a[i] > a[m]) {
                    m = i;
                }
            }

            a[n] = a[0];
            long k = -a[m];
            for (int i = 0; i < n; i++) {
                k += Math.max(a[i], a[i + 1]);
            }

            System.out.println(k);
        }
    }
}
