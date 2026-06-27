import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int max = 1;

            for (int i = 1; i * i <= x; i++) {
                if (x % i == 0) {

                    if ((long) i * n <= x) {
                        max = Math.max(max, i);
                    }

                    int oth = x / i;
                    if ((long) oth * n <= x) {
                        max = Math.max(max, oth);
                    }

                }

            }

            System.out.println(max);
        }
    }

}
