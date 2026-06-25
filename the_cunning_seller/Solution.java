import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        long[] p = new long[21];
        p[0] = 1;
        for (int i = 1; i < 21; i++) {
            p[i] = p[i - 1] * 3;
        }
        
        while (t-- > 0) {

            long n = Long.parseLong(br.readLine());
            // he can sell 3^x watermelons for 3(3^x) + x * 1/3(3^x) coins;
            // deal A : buying 1 watermelon for 3 coins
            // deal B : buying 3^x watermelons for 3^x + 1 + x * 3^(x - 1) coins;

            long min_cost = 0;
            int x = 0;
            while (n > 0) {
                min_cost += (n % 3) * fun(x, p);
                n /= 3;
                x++;
            }
            System.out.println(min_cost);

        }

    }

    static long fun(int x, long[] p) {

        if (x - 1 >= 0) {
            return p[x + 1] + x * p[x - 1];
        } else {
            return p[x + 1];
        }
    }
}
