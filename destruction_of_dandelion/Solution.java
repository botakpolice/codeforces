import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            LinkedList<Integer> odds = new LinkedList<>();
            List<Integer> evens = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                if (x % 2 == 0) {
                    evens.add(x);
                } else {
                    odds.add(x);
                }
            }

            long res = 0;
            if (odds.isEmpty()) {
                System.out.println(0);
                continue;
            } else {
                odds.sort(null);
                res += odds.pollLast();
                for (int i = 0; i < evens.size(); i++) {
                    res += evens.get(i);
                }

                boolean on = true;
                while (!odds.isEmpty()) {
                    if (on) {
                        odds.pollFirst();
                    } else {
                        res += odds.pollLast();
                    }
                    on = !on;
                }

                System.out.println(res);


            }


        }

    }
}
