import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            HashSet<Integer> a = new HashSet<>();
            HashSet<Integer> b = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                a.add(x);
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int x = Integer.parseInt(st.nextToken());
                b.add(x);
            }

            int chooseA = 0;
            int chooseB = 0;
            int chooseAorB = 0;
            boolean ok = true;
            for (int i = 1; i <= k; i++) {
                if (a.contains(i) && !b.contains(i)) {
                    chooseA++;
                } else if (b.contains(i) && !a.contains(i)) {
                    chooseB++;
                } else if (a.contains(i) || b.contains(i)) {
                    chooseAorB++;
                } else {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                int total = chooseA + chooseB + chooseAorB;
                if (chooseA * 2 <= k && chooseB * 2 <= k && total == k) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("NO");
            }

        }
    }

}
