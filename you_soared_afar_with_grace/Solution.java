import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n + 1];
            int[] b = new int[n + 1];
            int[] p = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                p[a[i]] = i;
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            solve(a, b, p, n);

        }
    }


    static void solve(int[] a, int[] b, int[] p, int n) {

        int x = 0;
        int[] m = new int[]{0};
        for (int i = 1; i <= n; i++) {
            if (a[i] == b[i]) {
                if (n % 2 == 0 || x > 0) {
                    System.out.println(-1);
                    return;
                }

                x = i;
            } else {
                // index of b[i] in a
                int idx = p[b[i]];
                if (b[idx] != a[i]) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        int[][] ans = new int[n + 1][2];
        if (n % 2 == 1) {
            swap(x, (n + 1) / 2, a, b, p, ans, m);
        }

        for (int i = 1; i <= n; i++) {
            swap(p[b[i]], n - i + 1, a, b, p, ans, m);
        }

        System.out.println(m[0]);
        for (int i = 1; i <= m[0]; i++) {
            System.out.println(ans[i][0] + " " + ans[i][1]);
        }
    }


    static void swap(int x, int y, int[] a, int[] b, int[] p, int[][] ans, int[] m) {
        if (x == y) {
            return;
        }

        m[0]++;
        ans[m[0]][0] = x;
        ans[m[0]][1] = y;
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;

        temp = p[a[x]];
        p[a[x]] = p[a[y]];
        p[a[y]] = temp;

        temp = b[x];
        b[x] = b[y];
        b[y] = temp;
    }

}
