import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();

            if (n <= 2) {
                System.out.println(Integer.parseInt(s));
            } else {

                int res = Integer.MAX_VALUE;
                for (int i = 0; i < n - 1; i++) {
                    int x = Integer.parseInt(s.substring(i, i + 2));
                    for (int k = i - 1; k >= 0; k--) {
                        int y = s.charAt(k) - '0';
                        if (x <= 1 || y <= 1) {
                            x *= y;
                        } else {
                            x += y;
                        }
                    }

                    for (int k = i + 2; k < n; k++) {
                        int y = s.charAt(k) - '0';
                        if (x <= 1 || y <= 1) {
                            x *= y;
                        } else {
                            x += y;
                        }
                    }

                    res = Math.min(res, x);

                }

                System.out.println(res);
            }

        }

    }
}
