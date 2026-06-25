import java.io.*;
import java.util.*;

public class reverse_xor {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            String s = Integer.toBinaryString(n);

            boolean ok = true;

            if (!check(s)) {
                ok = false;
            }

            if (!ok) {

                for (int i = 0; i < 30; i++) {
                    s = "0" + s;
                    if (check(s)) {
                        ok = true;
                        break;
                    }
                }

            }

            System.out.println(ok ? "YES" : "NO");
        }
    }

    static boolean check(String s) {

        int k = s.length();
        // check palindrome
        for (int i = 0; i < k / 2; i++) {
            if (s.charAt(i) != s.charAt(k - 1 - i)) {
                return false;
            }
        }

        // check middle bit
        if (k % 2 == 1 && s.charAt(k / 2) == '1') {
            return false;
        }

        return true;

    }

}
