import java.io.*;
import java.util.*;

public class simons_and_cakes {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // find the smallest k^n for which k is divisible by n
            // we only need to find the product of the primes of n once because it is all powered by n 
            long n = Long.parseLong(br.readLine());
            long res = 1;
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    res *= i;
                    while (n % i == 0) {
                        n /= i;
                    }
                }
            }

            System.out.println(res * n);
        }


    }
}
