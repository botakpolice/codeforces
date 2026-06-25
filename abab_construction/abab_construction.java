import java.io.*;
import java.util.*;

public class abab_construction {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            if (n % 2 == 1) {
                if (s.charAt(0) == 'b') {
                    System.out.println("NO");
                    continue;
                }
                boolean ok = true;
                for (int i = 1; i < n - 1; i+=2) {
                    if ((s.charAt(i) != '?' && s.charAt(i + 1) != '?') && s.charAt(i) == s.charAt(i + 1)) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                boolean ok = true;
                for (int i = 0; i < n - 1; i += 2) {
                    if ((s.charAt(i) != '?' && s.charAt(i + 1) != '?') && s.charAt(i) == s.charAt(i + 1)) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }

            }
        }
    }
}

