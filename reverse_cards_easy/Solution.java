import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {

            st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            long m = Long.parseLong(st.nextToken());
            long res = 0;
            for (long b = 1; b <= m; b++) {
                res += (n + b) / (b * b);
                if (b == 1) {
                    res--;
                }
            }

            System.out.println(res);

        }
    }

}
