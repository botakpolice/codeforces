import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            boolean removed = false;
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            int[] b = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i < n; i++) {
                b[i] = gcd(a[i], a[i - 1]);
            }

            int x = -1;
            for (int i = 1; i < n; i++) {
                if (b[i] < b[i - 1]) {
                    x = i;
                    break;
                }
            }

            if (x == -1) {
                System.out.println("YES");
            } else if (check(x - 2, a) || check(x - 1, a) || check (x, a)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
 
        }
    }

    static boolean check(int x, int[] a) {
        int n = a.length;
        int[] c = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (i == x) {
                continue;
            }
            c[j++] = a[i];
        }

        int last = 0;
        for (int i = 1; i < n - 1; i++) {
            int g = gcd(c[i], c[i - 1]);
            if (g < last) {
                return false;
            }
            last = g;
        }

        return true;
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a% b);
    }
}
