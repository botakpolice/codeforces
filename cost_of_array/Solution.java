import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            k /= 2;
            solve(a, n, k);
        }

    }

    static void solve(int[] a, int n, int k) {
        if (2 * k == n) {
            for (int i = 1; i < n; i += 2) {
                if (a[i] != (i + 1) / 2) {
                    System.out.println((i + 1) / 2);
                    return;
                }
            }

            System.out.println(k + 1);
        } else {
            for (int i = 1; i <= n - 2 * k + 1; i++) {
                if (a[i] != 1) {
                    System.out.println(1);
                    return;
                }
            }
            System.out.println(2);
            return;
        }

    }
}
