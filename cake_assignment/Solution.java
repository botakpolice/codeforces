import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            long cakes = 1L << k;
            if (x == 0 || x == cakes * 2) {
                System.out.println(-1);
                continue;
            }
            long y = cakes * 2 - x;
            // x is chocola, y is vanilla
            // 1 = chocola giving half her cakes
            // 2 = vanilla giving half her cakes
            Stack<Integer> steps = new Stack<>();
            while (x != cakes) {
                if (x > y) {
                    // vanilla gave chocola 
                    steps.add(2);
                    x -= y;
                    y *= 2;
                } else {
                    steps.add(1);
                    y -= x;
                    x *= 2;
                }
            }

            System.out.println(steps.size());
            StringBuilder sb = new StringBuilder();
            while (!steps.isEmpty()) {
                sb.append(steps.pop()).append(" ");
            }

            System.out.println(sb.toString());
        }

    }
}
