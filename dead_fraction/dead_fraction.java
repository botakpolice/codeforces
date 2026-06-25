import java.util.*;

class Solution {


    // a/b + c/d = (a * d + b * c) / b * d

    static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    static long pow10(int x) {
        long res = 1;
        for (int i = 0; i < x; i++) {
            res *= 10;
        }
        return res;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            if (s.equals("0")) {
                break;
            }

            int k = s.indexOf("...");
            // general formula is (ab - a) / (10^(r + p) - 10^(p));
            long ab = Long.parseLong(s.substring(2,k));
            long currDen = Long.MAX_VALUE;
            long currNum = 0;
            for (int i = 2; i < k; i++) {
                long a = i == 2 ? 0 : Long.parseLong(s.substring(2,i));
                long num = ab - a;
                long den = pow10(k - 2) - pow10(i - 2);
                long g = gcd(num , den);
                num /= g;
                den /= g;
                if (den < currDen) {
                    currNum = num;
                    currDen = den;
                }
            }
            System.out.println(currNum + "/" + currDen);

        }
    }
}

