import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            List<Integer> res = new ArrayList<>();
            int lastOdd = -1;
            if (n < 5) {
                System.out.println(-1);
                continue;
            }
            for (int i = 1; i <= n; i+=2) {
                if (i != 5) {
                    res.add(i);
                }
            }
            res.add(5);
            res.add(4);
            for (int i = 2; i <= n; i += 2) {
                if (i != 4) {
                    res.add(i);
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int x : res) {
                sb.append(x).append(" ");
            }

            System.out.println(sb.toString().trim());
        }

    }

}
