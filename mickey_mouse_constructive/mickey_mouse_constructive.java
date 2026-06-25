import java.io.*;
import java.util.*;

public class mickey_mouse_constructive {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int mod = 676767677;
        while (t-- > 0) {
            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int s = Math.abs(x - y);
            int res = 0;
            while (x > 0) {
                sb.append("1" + " ");
                x--;
            }
            while (y > 0) {
                sb.append("-1" + " ");
                y--;
            }

            for (int i = 1; i <= s; i++) {
                if (s % i == 0) {
                    res++;
                }
            }
            if (s == 0) {
                res = 1;
            }

            System.out.println(res % mod);
            System.out.println(sb.toString().trim());
        }

    }

}
