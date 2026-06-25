import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            long mod = (long) (1e9 + 7);
            long sum = 0;
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
                sum = (sum + a[i]) % mod;
            }

            long res = 0;
            for (int i = 0; i < n; i++) {
                long ai = a[i] % mod;
                long other = (sum - ai + mod) % mod;
                res = (res + ai * other) % mod;
            }

            long p = (long) n * (n - 1) % mod;
            p = (p * modInverse(2, mod)) % mod;
            res = (res * modInverse((2 * p) % mod, mod)) % mod;
            System.out.println(res);

        }

    }

    static long modInverse(long a, long mod) {
        return modPow(a, mod - 2, mod);
    }

    static long modPow(long a, long b, long mod) {
        long res = 1;
        a %= mod;

        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % mod;
            }

            a = a * a % mod;
            b >>= 1;
        }

        return res;
    }
}
