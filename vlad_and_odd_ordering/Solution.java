import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {

            long multiplier = 1;
            st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());

            while (true) {

                long count = (n + 1) / 2;

                if (k <= count) {
                    long ans = multiplier * (2 * k - 1);
                    System.out.println(ans);
                    break;
                }

                k-= count;
                n /= 2;
                multiplier *= 2;
            }
        }
    }

}
