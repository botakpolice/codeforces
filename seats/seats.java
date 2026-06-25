import java.io.*;
import java.util.*;

public class seats {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            int n = Integer.parseInt(sc.nextLine());
            String s = sc.nextLine();
            int res = 0;
            if (n <= 2) {
                System.out.println(1);
                continue;
            }
            char[] ch = s.toCharArray();
            if (ch[0] == '0' && ch[1] == '0') {
                ch[1] = '1';
            }

            if (ch[n - 1] == '0' && ch[n - 2] == '0') {
                ch[n - 2] = '1';
            }

            int l = 0;
            for (int i = 0; i < n; i++) {
                if (ch[i] == '0') {
                    if (i - l >= 3) {
                        res++;
                        l = i;
                    }
                } else {
                    res++;
                    l = i;
                }
            }
            System.out.println(res);
        }
    }
}
