import java.io.*;
import java.util.*;

public class drifting_away {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String cells = sc.nextLine();
            int n = cells.length();
            int left = 0, right = 0;
            boolean ok = true;
            for (int i = 0; i < n - 1; i++) {
                if (cells.charAt(i) != '<' && cells.charAt(i + 1) != '>') {
                    ok = false;
                    break;
                }
            }

            for (char c : cells.toCharArray()) {
                if (c == '<') {
                    left++;
                } else if (c == '>') {
                    right++;
                }
            }

            if (!ok) {
                System.out.println(-1);
            } else {
                System.out.println(n - Math.min(left, right));
            }

        }
        
    }
}
