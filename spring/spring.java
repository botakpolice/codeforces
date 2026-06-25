import java.io.*;
import java.util.*;

public class spring {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            long m = Long.parseLong(st.nextToken());

            long A = m / a;
            long B = m / b;
            long C = m / c;
            long AB = m / lcm(a,b);
            long AC = m / lcm(a,c);
            long BC = m / lcm(b,c);
            long ABC = m / lcm(lcm(a,b), c);

            long onlyA = A - AB - AC + ABC;
            long onlyB = B - AB - BC + ABC;
            long onlyC = C - AC - BC + ABC;

            long onlyAB = AB - ABC;
            long onlyAC = AC - ABC;
            long onlyBC = BC- ABC;

            long wa = 6 * onlyA + 3 * onlyAB + 3 * onlyAC + 2 * ABC;
            long wb = 6 * onlyB + 3 * onlyAB + 3 * onlyBC + 2 * ABC;
            long wc = 6 * onlyC + 3 * onlyAC + 3 * onlyBC + 2 * ABC;

            System.out.println(wa + " " + wb + " " + wc);
        }
    }


    static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    } 
}
