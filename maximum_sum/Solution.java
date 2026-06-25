import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int mod = (int) (1e9 + 7);
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            
            long max = 0;
            long curr = 0;
            long res = 0;
            for (int i = 0; i < n; i++) {
                curr = Math.max(a[i], curr + a[i]);
                max = Math.max(curr, max);
                res += a[i];
            }

            long powerOfTwo = 1;
            while (k > 0) {
                powerOfTwo = (powerOfTwo * 2) % mod;
                k--;
            }

            long maxMod = max % mod;
            long addedVal = (maxMod * powerOfTwo) % mod;
            res = (res - maxMod + addedVal) % mod;
            res = (res + mod) % mod;
            System.out.println(res);

        }
    }

}
