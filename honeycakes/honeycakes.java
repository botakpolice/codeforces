import java.io.*;
import java.util.*;

public class honeycakes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long w = sc.nextLong();
        long h = sc.nextLong();
        long d = sc.nextLong();
        long n = sc.nextLong();

        for (long x = 1; x * x * x <= n; x++) {
            if (n % x != 0) {
                continue;
            }

            for (long y = 1; y * y <= n / x; y++) {
                if ((n/x) % y != 0) {
                    continue;
                }

                long z = n / (x * y);
                long[][] perms = {
                    {x, y ,z}, {x, z, y},
                    {y, x, z}, {y, z, x},
                    {z, x, y}, {z, y, x}
                };
                for (long[] p : perms) {
                    long a = p[0], b = p[1], c = p[2];
                    if (w % a == 0 && h % b == 0 && d % c == 0) {
                        System.out.println((a - 1) + " " + (b - 1) + " " + (c - 1));
                        return;
                    }
                }
            }
        }

        System.out.println(-1);
    }
}
