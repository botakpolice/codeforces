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
            long m = Long.parseLong(st.nextToken());

            HashMap<Integer,Integer> ctr = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                ctr.put(x, ctr.getOrDefault(x,0) + 1);
            }

            long res = 0;
            for (int k : ctr.keySet()) {

                int cntK = ctr.get(k);
                int cntK1 = ctr.getOrDefault(k + 1, 0);

                for (long y = 0; y <= cntK1; y++) {
                    long spent = (k + 1L) * y;
                    if (spent > m) {
                        break;
                    }

                    long remain = m - spent;
                    long x = Math.min(cntK, remain / k);

                    res = Math.max(res, spent + x * k);
                }
            }

            System.out.println(res);
        }

    }
}
