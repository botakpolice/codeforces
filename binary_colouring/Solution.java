import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int x = Integer.parseInt(br.readLine());

            int[] res = new int[31];
            for (int i = 0; i < 30; i++) {
                if ((1L & (x >> i)) == 1) {
                    if (res[i] == 1) {
                        res[i + 1] = 1;
                        res[i] = 0;
                    } else if (i > 0) {
                        if (res[i - 1] == 1) {
                            res[i + 1] = 1;
                            res[i - 1] = -1;
                        } else {
                            res[i] = 1;
                        }
                    } else if (i == 0) {
                        res[i] = 1;
                    }
                }
            }

            System.out.println(31);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= 30; i++) {
                sb.append(res[i]).append(" ");
            }

            System.out.println(sb.toString().trim());
        }
    }
}
