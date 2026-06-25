import java.io.*;
import java.util.*;

public class flipping_binary_string {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            int zeros = 0;
            for (int i = 0; i < n; i++) {
                zeros += s.charAt(i) == '0' ? 1 : 0;
            }

            int ones = n - zeros;
            if (ones % 2 != 0 && n % 2 != 0) {
                System.out.println(-1);
                continue;
            }

            if (zeros % 2 == 0 && ones % 2 == 0) {
                System.out.println(ones);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    if (s.charAt(i) == '1') {
                        sb.append(i + 1).append(" ");
                    }
                }
                if (ones > 0) {
                    System.out.println(sb.toString().trim());
                }
            } else if (zeros % 2 != 0) {
                System.out.println(zeros);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    if (s.charAt(i) == '0') {
                        sb.append(i + 1).append(" ");
                    }
                }
                if (zeros > 0) {
                    System.out.println(sb.toString().trim());

                }
            }


        }
    }
}
