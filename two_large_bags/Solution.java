import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            TreeMap<Integer,Integer> ctr = new TreeMap<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                ctr.put(x, ctr.getOrDefault(x, 0) + 1);
            }

            boolean ok = true;
            while (!ctr.isEmpty()) {
                int min = ctr.firstKey();
                if (ctr.get(min) == 1) {
                    ok = false;
                    break;
                }

                int x = ctr.getOrDefault(min + 1, 0) + ctr.get(min) - 2;
                if (x > 0) {
                    ctr.put(min + 1, x);
                }
                ctr.remove(min);
            }

            if (ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}
