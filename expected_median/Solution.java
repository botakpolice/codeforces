import java.io.*;
import java.util.*;

public class Solution {

    static long mod = (long) (1e9 + 7); 
    static long[] fact = new long[200006];
    static long[] invFact = new long[200006];
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        precompute(200005);
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            int numOnes = 0;
            for (int i = 0; i < n; i++) {
                numOnes += a[i];
            }

            int req = (k + 1) / 2;
            long res = 0;
            for (int cnt_ones = (k + 1) / 2; cnt_ones <= Math.min(k, numOnes); cnt_ones++) {
                long combs = nCr(numOnes, cnt_ones) * nCr(n - numOnes, k - cnt_ones) % mod;
                res = (res + combs) % mod;
            }

            System.out.println(res);

        }

    }

    static void precompute(int n) {
        fact[0] = 1;
        for (int i = 1; i <= n; i ++) {
            fact[i] = fact[i - 1] * i % mod;
        }

        invFact[n] = pow(fact[n], mod - 2);
        for (int i = n - 1; i>= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % mod;
        }
    }

    static long nCr(int n, int r) {
        if (r > n) {
            return 0;
        }

        // formula : n! / r!(n - r)!
        return fact[n] * invFact[r] % mod * invFact[n - r] % mod;
    }


    static long pow(long a, long b) {
        long res = 1;
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
