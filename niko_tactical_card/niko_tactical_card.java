import java.io.*;
import java.util.*;

public class niko_tactical_card {

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

            long[] max = new long[n + 1];
            long[] min = new long[n + 1];

            Arrays.fill(max, Long.MIN_VALUE);
            Arrays.fill(min, Long.MAX_VALUE);

            max[0] = 0;
            min[0] = 0;

            for (int i = 0; i < n; i++) {
                long x = Math.max(max[i] - a[i], b[i] - max[i]);
                long y = Math.max(min[i] - a[i], b[i] - min[i]);
                long z = Math.min(max[i] - a[i], b[i] - max[i]);
                long l = Math.min(min[i] - a[i], b[i] - min[i]);
                max[i + 1] = Math.max(x, y);
                min[i + 1] = Math.min(z, l);
            }

            System.out.println(Math.max(min[n], max[n]));


        }
    }
}
