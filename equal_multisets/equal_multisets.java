import java.io.*;
import java.util.*;

public class equal_multisets {
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

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

            boolean[] seen = new boolean[n + 1];
            boolean ok = true;
            for (int i = 0; i < n; i++) {
                if (i < n - k || i >= k) {
                    if (b[i] == -1) {
                        b[i] = a[i];
                    }
                    if (b[i] != a[i]) {
                        ok = false;
                        break;
                    }
                }
                if (b[i] != -1) {
                    if (seen[b[i]]) {
                        ok = false;
                        break;
                    }
                    seen[b[i]] = true;
                }
            }
            if (ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
