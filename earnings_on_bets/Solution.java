import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            long lm = a[0];
            for (int i = 1; i < n; i++) {
                lm = lcm(lm, a[i]); 
            }

            int suma = 0;
            for (int i = 0; i < n; i++) {
                suma += lm / a[i];
            }
            if (lm <= suma) {
                System.out.println(-1);
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(lm / a[i]).append(" ");
            }

            System.out.println(sb.toString().trim());
        }

    }


    static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    static long gcd(long a , long b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
