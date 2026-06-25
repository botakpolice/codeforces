import java.io.*;
import java.util.*;

public class xor_convenience {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] p = new int[n + 1];

            p[n] = 1;
            for (int i = 2; i <= n - 1; i++) {
                p[i] = i ^ 1;
            }

            p[1] = n;
            if (n % 2 != 0) {
                p[1] = n - 1;
            }
            
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                sb.append(p[i]).append(" ");
            }

            System.out.println(sb.toString().trim());
        }
    }
}
