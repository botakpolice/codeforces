import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            List<Long> evens = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            long pre = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {

                long x = Long.parseLong(st.nextToken());
                if (x % 2 == 0) {
                    evens.add(x);
                } else {
                    pre = Math.max(pre, x);
                }
            }

            evens.sort(null);
            if (evens.size() == n) {
                System.out.println(0);
                continue;
            }
            long res = evens.size();
            for (int i = 0; i < evens.size(); i++) {
                long curr = evens.get(i);
                if (pre > curr) {
                    pre += curr;
                } else {
                    res++;
                    break;
                }
            }

            System.out.println(res);
        }

    }
}
