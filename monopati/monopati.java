import java.io.*;
import java.util.*;

public class monopati {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            int[] b = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            int[] suf_max = new int[n];
            int[] suf_min = new int[n];

            suf_max[n - 1] = b[n - 1];
            suf_min[n - 1] = b[n - 1];

            for (int i = n - 2; i >= 0; i--) {
                suf_max[i] = Math.max(suf_max[i + 1], b[i]);
                suf_min[i] = Math.min(suf_min[i + 1], b[i]);
            }

            int[] res = new int[2*n];
            Arrays.fill(res, 2*n);
            int pref_min = a[0], pref_max = a[0];
            for (int i = 0; i < n; i++) {
                pref_min = Math.min(pref_min, a[i]);
                pref_max = Math.max(pref_max, a[i]);

                // min represent l, max represent r
                int min = Math.min(pref_min, suf_min[i]);
                int max = Math.max(pref_max, suf_max[i]);

                // for each l, we find the min r;
                res[min - 1] = Math.min(res[min - 1], max - 1);
            }
            System.out.println(Arrays.toString(res));

            for (int i = 2*n - 2; i >= 0; i--) {
                res[i] = Math.min(res[i], res[i + 1]);
            }

            long ans = 0;
            for (int x : res) {
                ans += (2*n - x);
            }

            System.out.println(ans);

        }
    }
}
