import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int N = 5001;
        int inf = (int) (1e9 + 5);

        int[][] g = new int[N][N];

        for (int x = 0; x < N; x++) {
            g[x][0] = g[0][x] = g[x][x] = x;
        }

        for (int x = 1; x < N; x++) {
            for (int y = 1; y < x; y++) {
                g[x][y] = g[y][x] = g[y][x % y];
            }
        }

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int m = 0;
            int k = 0;
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                k = g[k][a[i]];
            }

            int[] f = new int[N];
            Arrays.fill(f, inf);

            for (int i = 0; i < n; i++) {
                a[i] /= k;
                if (a[i] > m) {
                    m = a[i];
                }
                f[a[i]] = 0;
            }

            for (int x = m; x >= 1; x--) {
                for (int i = 0; i < n; i++) {
                    int y = a[i];
                    if (f[x] + 1 < f[g[x][y]]) {
                        f[g[x][y]] = f[x] + 1;
                    }
                }
            }

            int ans = Math.max(f[1] - 1, 0);
            for (int i = 0; i < n; i++) {
                if (a[i] > 1) {
                    ans++;
                }
            }

            System.out.println(ans);
        }

    }


    static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
