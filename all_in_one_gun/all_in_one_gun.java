import java.io.*;
import java.util.*;

public class all_in_one_gun {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            long s = 0;
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                s += a[i];
            }

            long res = (h / s) * (k + n);
            long rem = h % s;
            if (rem == 0) {
                res -= k;
                System.out.println(res);
                continue;
            }

            if (rem > 0) {

                int[] suffMax = new int[n + 1];
                for (int i = n - 1; i >= 0; i--) {
                    suffMax[i] = Math.max(a[i], suffMax[i + 1]);
                }

                long[] prefSum = new long[n + 1];
                int[] prefMin = new int[n + 1];
                prefMin[0] = Integer.MAX_VALUE;
                for (int i = 0; i < n; i++) {
                    prefSum[i + 1] = prefSum[i] + a[i];
                    prefMin[i + 1] = Math.min(a[i], prefMin[i]);
                }

                int best = n;
                for (int i = 1; i <= n; i++) {
                    long damage = prefSum[i];
                    damage = Math.max(damage, prefSum[i] - prefMin[i] + suffMax[i]);
                    if (damage >= rem) {
                        best = i;
                        break;
                    }
                }

                res += best;
                System.out.println(res);
            }

        }
    }
}
