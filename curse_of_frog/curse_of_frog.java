import java.io.*;
import java.util.*;

public class curse_of_frog {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long x = Long.parseLong(st.nextToken());

            long best = Long.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                long val = (long) a * b - c;
                best = Math.max(best, val);

                x -= (long) (b - 1) * a;
            }
            if (x <= 0) {
                System.out.println(0);
                continue;
            } else {
                if (best <= 0) {
                    System.out.println(-1);
                    continue;
                }
                long rollbacks = (x + best - 1) / best;
                System.out.println(rollbacks);
            }
        }
    }

}
