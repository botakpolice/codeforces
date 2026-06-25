import java.io.*;
import java.util.*;

public class monster_game {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            Integer[] a = new Integer[n + 1];
            int[] b = new int[n + 1];

            for (int i = 1; i <= n ; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(a, 1, n + 1, Collections.reverseOrder());
            int level = 0, strikes = 0;
            long res = 0;
            for (int i = 1; i <= n; i++) {
                while (level < n && strikes + b[level + 1] <= i) {
                    level++;
                    strikes += b[level];
                }

                res = Math.max(res, (long)a[i] * level);
            }
            System.out.println(res);
        }
    }
}
