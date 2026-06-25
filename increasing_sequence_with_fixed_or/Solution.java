import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            long n = Long.parseLong(br.readLine());

            ArrayList<Long> a = new ArrayList<>();

            for (int i = 62; i >= 0; i--) {
                long x = 1L << i;  // important: use 1L

                if ((x & n) == x && x != n) {
                    System.out.println(x);
                    a.add(n - x);
                }
            }

            a.add(n);

            System.out.println(a.size());

            StringBuilder sb = new StringBuilder();

            for (long x : a) {
                sb.append(x).append(" ");
            }

            System.out.println(sb.toString().trim());
        }
    }
}
