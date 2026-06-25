import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // n(n + 1) / 2 <= total;

            long total = w + b;
            long n = (long) ((Math.sqrt(1 + 8 * total) - 1) / 2);
            if (n * (n + 1) / 2 > total) {
                n--;
            }

            if ((n + 1) * (n + 2) / 2 <= total) {
                n++;
            }

            System.out.println(n);
        }

    }
}
