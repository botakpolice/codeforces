import java.io.*;
import java.util.*;

public class rae_taylor_and_trees {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int[] p = new int[n + 1];
            int[] pre = new int[n + 1];
            int[] suf = new int[n + 2];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                p[i] = Integer.parseInt(st.nextToken());
                pre[i] = Math.min(pre[i - 1], p[i]);
            }

            for (int i = n; i >= 1; i--) {
                suf[i] = Math.max(suf[i + 1], p[i]);
            }

            boolean ok = true;
            for (int i = 2; i <= n; i++) {
                if (pre[i - 1] > suf[i]) {
                    ok = false;
                    break;
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
