import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long sol = -1;
            if ((a + b) % 2 == 0) {
                sol = a + b;
            }
            if (a % 2 == 1 && b % 2 == 1) {
                sol = Math.max(sol, a * b + 1);
            } else if ((b % 2 == 0) && (b % 4 == 0 || a % 2 == 0)) {
                sol = Math.max(sol, 2 + (a * b) / 2);
            }

            System.out.println(sol);
        }

    }
}
