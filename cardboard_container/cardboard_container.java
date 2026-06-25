import java.util.*;

class Solution {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int v = Integer.parseInt(sc.nextLine());

        int best = Integer.MAX_VALUE;
        for (int a = 1; a * a * a <= v; a++) {
            if (v % a != 0) {
                continue;
            }
            int m = v / a;
            for (int b = a; b * b <= m; b++) {
                if (m % b != 0) {
                    continue;
                }

                int c = m / b;
                int s = 2 * (a*b + b*c + c*a);
                best = Math.min(best, s);
            }
        }

        System.out.println(best);
    }
}
