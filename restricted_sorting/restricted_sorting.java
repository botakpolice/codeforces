import java.io.*;
import java.util.*;

public class restricted_sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0 ; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                a[i] = b[i] = x;
            }

            Arrays.sort(b);
            if (Arrays.equals(a,b)) {
                System.out.println(-1);
                continue;
            }

            int maxK = b[n - 1] - b[0];
            for (int i = 0; i < n; i++) {
                if (a[i] != b[i]) {
                    int m = Math.max(a[i] - b[0], b[n - 1] - a[i]);
                    maxK = Math.min(maxK, m);
                }
            }

            System.out.println(maxK);
        }
    }
}
