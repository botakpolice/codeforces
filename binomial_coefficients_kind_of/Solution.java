import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        int[] n = new int[t];
        int[] k = new int[t];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < t; i++) {
            n[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < t; i++) {
            k[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < t; i++) {
            long ans = powm(2, k[i]);
            System.out.println(ans);
        }
    }

    static long powm(long x, long n) {
        long mod = (long) (1e9 + 7);
        x %= mod;
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        }

        long p = powm(x * x, n / 2);
        if (n % 2 == 1) {
            return p * x % mod;
        } else {
            return p;
        }
    }
}
