import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int bits = Integer.bitCount(x);
            if (n <= bits) {
                System.out.println(x);
                continue;
            }

            if ((n - bits) % 2 == 0) {
                System.out.println(x + n - bits);
            } else {

                if (x > 1) {
                    System.out.println(x + n - bits + 1);
                } else if (x == 1) {
                    System.out.println(n + 3);
                } else {
                    if (n == 1) {
                        System.out.println(-1);
                    } else {
                        System.out.println(n + 3);
                    }
                }
            }
        }

    }
}
